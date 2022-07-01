package com.cmv.borusan.service;

import com.cmv.borusan.exception.*;
import com.cmv.borusan.model.dto.ProductDto;
import com.cmv.borusan.model.dto.ProductPageableDto;
import com.cmv.borusan.model.dto.ProductSearch;
import com.cmv.borusan.model.entity.*;
import com.cmv.borusan.model.mapper.ProductMapper;
import com.cmv.borusan.repository.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import javax.xml.bind.DatatypeConverter;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

@Getter
@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    private final ProductGroupRepository productGroupRepository;

    private final ProductSubGroupRepository productSubGroupRepository;

    private final ProductSubGroupDetailRepository productSubGroupDetailRepository;

    private final ProductLastDetailRepository productLastDetailRepository;

    private final LocationRepository locationRepository;

    private final SubLocationRepository subLocationRepository;

    private final SubLocationDetailRepository subLocationDetailRepository;

    private final WorkerRepository workerRepository;

    private final ProductAreaRepository productAreaRepository;

    private final ColourRepository colourRepository;

    private final NumberPlateRepository numberPlateRepository;

    @Value("${app.file.path.base}")
    private String FILE_PATH_BASE;

    private String FILE_URL_BASE = "";

    public List<ProductDto> getAll() {
        return ProductMapper.mapToList(productRepository.findAll());
    }

    public LocalDateTime getTime() {
        LocalDateTime now = LocalDateTime.now();
        return now;
    }

    public boolean saveWeb(ProductDto productDto) {
        Product product = ProductMapper.mapTo(productDto);

        Optional<Product> productOptional = productRepository.findByProductBarcode(productDto.getProductBarcode());
        if (productOptional.isPresent()) {
            throw new IllegalArgumentException("Kayıtlı barkod!");
        }

        Optional<Location> location = locationRepository.findById(productDto.getLocationId());
        if (location.isPresent()) {
            product.setLocation(location.get());
        } else {
            throw new IllegalArgumentException("locationId giriniz!");
        }
        Optional<ProductGroup> productGroup = productGroupRepository.findById(productDto.getProductGroupId());
        if (productGroup.isPresent()) {
            product.setProductGroup(productGroup.get());
        } else {
            throw new IllegalArgumentException("productGroupId giriniz!");
        }

        if (productDto.getSubLocationId() != null) {
            Optional<SubLocation> subLocation = subLocationRepository.findById(productDto.getSubLocationId());
            if (subLocation.isPresent()) {
                product.setSubLocation(subLocation.get());
            }
        }
        if (productDto.getSubLocationDetailId() != null) {
            Optional<SubLocationDetail> subLocationDetail = subLocationDetailRepository.findById(productDto.getSubLocationDetailId());
            if (subLocationDetail.isPresent()) {
                product.setSubLocationDetail(subLocationDetail.get());
            }
        }
        if (productDto.getProductSubGroupId() != null) {
            Optional<ProductSubGroup> productSubGroup = productSubGroupRepository.findById(productDto.getProductSubGroupId());
            if (productSubGroup.isPresent()) {
                product.setProductSubGroup(productSubGroup.get());
            }
        }
        if (productDto.getProductSubGroupDetailId() != null) {
            Optional<ProductSubGroupDetail> productSubGroupDetail = productSubGroupDetailRepository.findById(productDto.getProductSubGroupDetailId());
            if (productSubGroupDetail.isPresent()) {
                product.setProductSubGroupDetail(productSubGroupDetail.get());
            }
        }
        if (productDto.getProductLastDetailId() != null) {
            Optional<ProductLastDetail> productLastDetail = productLastDetailRepository.findById(productDto.getProductLastDetailId());
            if (productLastDetail.isPresent()) {
                product.setProductLastDetail(productLastDetail.get());
            }
        }
        if (productDto.getWorkerId() != null) {
            Optional<Worker> worker = workerRepository.findById(productDto.getWorkerId());
            if (worker.isPresent()) {
                product.setWorker(worker.get());
            }
        }
        productRepository.save(product);
        return true;
    }

    public ProductDto save(ProductDto productDto) {
        Product product = ProductMapper.mapTo(productDto);

        Optional<Product> productOptional = productRepository.findByProductBarcode(productDto.getProductBarcode());
        if (productOptional.isPresent()) {
            throw new KayitliBarcodeException(productDto.getProductBarcode());
        }

        Optional<Location> location = locationRepository.findById(productDto.getLocationId());
        if (location.isPresent()) {
            product.setLocation(location.get());
        } else {
            throw new IllegalArgumentException("locationId giriniz!");
        }
        Optional<ProductGroup> productGroup = productGroupRepository.findById(productDto.getProductGroupId());
        if (productGroup.isPresent()) {
            product.setProductGroup(productGroup.get());
        } else {
            throw new IllegalArgumentException("productGroupId giriniz!");
        }

        if (productDto.getSubLocationId() != null) {
            Optional<SubLocation> subLocation = subLocationRepository.findById(productDto.getSubLocationId());
            if (subLocation.isPresent()) {
                product.setSubLocation(subLocation.get());
            }
        }

        if (productDto.getSubLocationName() !=null){
            Optional<SubLocation> subLocation = Optional.ofNullable(subLocationRepository.findByName(productDto.getSubLocationName()));
            if (subLocation.isPresent()){
                product.setSubLocation(subLocation.get());
            }
            else {
                throw new KayitsizLocationException(productDto.getSubLocationName());
            }
        }

        if (productDto.getSubLocationName() == null){
            throw new UygulamaGuncelleException(productDto.getLocations());
        }



        if (productDto.getSubLocationDetailId() != null) {
            Optional<SubLocationDetail> subLocationDetail = subLocationDetailRepository.findById(productDto.getSubLocationDetailId());
            if (subLocationDetail.isPresent()) {
                product.setSubLocationDetail(subLocationDetail.get());
            }
        }


        if (productDto.getProductAreaId() != null){
            Optional<ProductArea> productArea = productAreaRepository.findById(productDto.getProductAreaId());
            if (productArea.isPresent()){
                product.setProductArea(productArea.get());
            }
        }

        if (productDto.getProductSubGroupId() != null) {
            Optional<ProductSubGroup> productSubGroup = productSubGroupRepository.findById(productDto.getProductSubGroupId());
            if (productSubGroup.isPresent()) {
                product.setProductSubGroup(productSubGroup.get());
            }
        }
        if (productDto.getProductSubGroupDetailId() != null) {
            Optional<ProductSubGroupDetail> productSubGroupDetail = productSubGroupDetailRepository.findById(productDto.getProductSubGroupDetailId());
            if (productSubGroupDetail.isPresent()) {
                product.setProductSubGroupDetail(productSubGroupDetail.get());
            }
        }
        if (productDto.getProductLastDetailId() != null) {
            Optional<ProductLastDetail> productLastDetail = productLastDetailRepository.findById(productDto.getProductLastDetailId());
            if (productLastDetail.isPresent()) {
                product.setProductLastDetail(productLastDetail.get());
            }
        }
        if (productDto.getWorkerId() != null) {
            Optional<Worker> worker = workerRepository.findById(productDto.getWorkerId());
            if (worker.isPresent()) {
                product.setWorker(worker.get());
            }
        }
        if (productDto.getColourId() != null){
            Optional<Colour> colour = colourRepository.findById(productDto.getColourId());
            if (colour.isPresent()){
                product.setColour(colour.get());
            }
        }
        if (productDto.getNumberPlateId() != null){
            Optional<NumberPlate> numberPlate = numberPlateRepository.findById(productDto.getNumberPlateId());
            if (numberPlate.isPresent()){
                product.setNumberPlate(numberPlate.get());
            }
        }

        if (productDto.getFileType() != null) {

            String fileType = product.getFileType();
            String encodedImage = productDto.getEncodedImage();

            Path filePath = createOrGetFolder();
            String uuid = UUID.randomUUID().toString();
            String publicFileName = uuid + "." + fileType.replace(".", "");

            byte[] result = DatatypeConverter.parseBase64Binary(encodedImage);

            try {
                try (OutputStream stream = new FileOutputStream(filePath + "/" + publicFileName)) {
                    stream.write(result);
                }

                product.setBaseUrl(FILE_URL_BASE);
                product.setBasePath(FILE_PATH_BASE);
                product.setDynamicPath("/" + getDate() + "/" + publicFileName);
                product.setPublicId(publicFileName);


            } catch (Exception e) {
                e.printStackTrace();
                throw new GeneralException("Dosya yüklenemedi!");
            }
        }

        if (productDto.getFileType1() != null) {

            String fileType1 = product.getFileType1();
            String encodedImage1 = productDto.getEncodedImage1();

            Path filePath1 = createOrGetFolder1();
            String uuid = UUID.randomUUID().toString();
            String publicFileName = uuid + "." + fileType1.replace(".", "");

            byte[] result = DatatypeConverter.parseBase64Binary(encodedImage1);

            try {
                try (OutputStream stream = new FileOutputStream(filePath1 + "/" + publicFileName)) {
                    stream.write(result);
                }

                product.setBaseUrl1(FILE_URL_BASE);
                product.setBasePath1(FILE_PATH_BASE);
                product.setDynamicPath1("/" + getDate() + "/" + publicFileName);
                product.setPublicId1(publicFileName);


            } catch (Exception e) {
                e.printStackTrace();
                throw new GeneralException("Dosya yüklenemedi!");
            }
        }

        if (productDto.getFileType2() != null) {

            String fileType2 = product.getFileType2();
            String encodedImage2 = productDto.getEncodedImage2();

            Path filePath2 = createOrGetFolder2();
            String uuid = UUID.randomUUID().toString();
            String publicFileName = uuid + "." + fileType2.replace(".", "");

            byte[] result = DatatypeConverter.parseBase64Binary(encodedImage2);

            try {
                try (OutputStream stream = new FileOutputStream(filePath2 + "/" + publicFileName)) {
                    stream.write(result);
                }

                product.setBaseUrl2(FILE_URL_BASE);
                product.setBasePath2(FILE_PATH_BASE);
                product.setDynamicPath2("/" + getDate() + "/" + publicFileName);
                product.setPublicId2(publicFileName);


            } catch (Exception e) {
                e.printStackTrace();
                throw new GeneralException("Dosya yüklenemedi!");
            }
        }

        productRepository.save(product);
        return productDto;

    }

    public Boolean delete(Long id) {
        productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id.toString(), Product.class));
        productRepository.deleteById(id);
        return true;
    }

    public ProductDto update(ProductDto productDto) {
        Product product1 = ProductMapper.mapTo(productDto);

        Optional<Product> productOptional = productRepository.findByProductBarcode(productDto.getProductBarcode());

        if (productDto.getLocationId() != null) {
            Optional<Location> location = locationRepository.findById(productDto.getLocationId());
            if (location.isPresent()) {
                product1.setLocation(location.get());
            }
        }
        if (productDto.getProductAreaId() != null){
            Optional<ProductArea> productArea = productAreaRepository.findById(productDto.getProductAreaId());
            if (productArea.isPresent()){
                product1.setProductArea(productArea.get());
            }
        }

        if (productDto.getProductGroupId() != null) {
            Optional<ProductGroup> productGroup = productGroupRepository.findById(productDto.getProductGroupId());
            if (productGroup.isPresent()) {
                product1.setProductGroup(productGroup.get());
            }
        }

        if (productDto.getSubLocationId() != null) {
            Optional<SubLocation> subLocation = subLocationRepository.findById(productDto.getSubLocationId());
            if (subLocation.isPresent()) {
                product1.setSubLocation(subLocation.get());
            }
        }

        if (productDto.getSubLocationName() !=null){
            Optional<SubLocation> subLocation = Optional.ofNullable(subLocationRepository.findByName(productDto.getSubLocationName()));
            if (subLocation.isPresent()){
                product1.setSubLocation(subLocation.get());
            }
            else {
                throw new KayitsizLocationException(productDto.getSubLocationName());
            }
        }

        if (productDto.getSubLocationName() == null){
            throw new UygulamaGuncelleException(productDto.getLocations());
        }


        if (productDto.getSubLocationDetailId() != null) {
            Optional<SubLocationDetail> subLocationDetail = subLocationDetailRepository.findById(productDto.getSubLocationDetailId());
            if (subLocationDetail.isPresent()) {
                product1.setSubLocationDetail(subLocationDetail.get());
            }
        }
        if (productDto.getProductSubGroupId() != null) {
            Optional<ProductSubGroup> productSubGroup = productSubGroupRepository.findById(productDto.getProductSubGroupId());
            if (productSubGroup.isPresent()) {
                product1.setProductSubGroup(productSubGroup.get());
            }
        }
        if (productDto.getProductSubGroupDetailId() != null) {
            Optional<ProductSubGroupDetail> productSubGroupDetail = productSubGroupDetailRepository.findById(productDto.getProductSubGroupDetailId());
            if (productSubGroupDetail.isPresent()) {
                product1.setProductSubGroupDetail(productSubGroupDetail.get());
            }
        }
        if (productDto.getProductLastDetailId() != null) {
            Optional<ProductLastDetail> productLastDetail = productLastDetailRepository.findById(productDto.getProductLastDetailId());
            if (productLastDetail.isPresent()) {
                product1.setProductLastDetail(productLastDetail.get());
            }
        }
        if (productDto.getWorkerId() != null) {
            Optional<Worker> worker = workerRepository.findById(productDto.getWorkerId());
            if (worker.isPresent()) {
                product1.setWorker(worker.get());
            }
        }

        if (productDto.getProductAreaId() != null) {
            Optional<ProductArea> productArea = productAreaRepository.findById(productDto.getProductAreaId());
            if (productArea.isPresent()) {
                product1.setProductArea(productArea.get());
            }
        }
        if (productDto.getColourId() != null) {
            Optional<Colour> colour = colourRepository.findById(productDto.getColourId());
            if (colour.isPresent()){
                product1.setColour(colour.get());
            }
        }

        if (productDto.getNumberPlateId() != null){
            Optional<NumberPlate> numberPlate = numberPlateRepository.findById(productDto.getNumberPlateId());
            if (numberPlate.isPresent()){
                product1.setNumberPlate(numberPlate.get());
            }
        }
        productRepository.save(product1);


        Product product = productRepository.findById(productDto.getId())
                .orElseThrow(() -> new EntityNotFoundException(productDto.getId().toString(), Product.class));
        ProductMapper.updateProduct(product, productDto);
        productRepository.save(product);
        return productDto;
    }

    private String getDate() {
        return OffsetDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMM"));
    }

    @SneakyThrows
    private Path createOrGetFolder() {
        Path filePath = Paths.get(FILE_PATH_BASE + "/" + getDate());

        if (!Files.exists(filePath)) {
            Files.createDirectory(filePath);
        }
        return filePath;
    }

    @SneakyThrows
    private Path createOrGetFolder1() {
        Path filePath = Paths.get(FILE_PATH_BASE + "/" + getDate());

        if (!Files.exists(filePath)) {
            Files.createDirectory(filePath);
        }
        return filePath;
    }

    @SneakyThrows
    private Path createOrGetFolder2() {
        Path filePath = Paths.get(FILE_PATH_BASE + "/" + getDate());

        if (!Files.exists(filePath)) {
            Files.createDirectory(filePath);
        }
        return filePath;
    }

    @SneakyThrows
    @Transactional
    public Product save(MultipartFile file) {
        Path filePath = createOrGetFolder();

        String publicFileName = "";
        String originalFilename = file.getOriginalFilename();
        if (originalFilename != null) {
            publicFileName = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));
        }
        Files.copy(file.getInputStream(), filePath.resolve(publicFileName));

        Product product = new Product();
        product.setBaseUrl(FILE_URL_BASE);
        product.setBasePath(FILE_PATH_BASE);
        product.setDynamicPath("/" + getDate() + "/" + publicFileName);
        product.setPublicId(publicFileName);
        product.setName(file.getOriginalFilename());

        return product;
    }

    @SneakyThrows
    @Transactional
    public Product save1(MultipartFile file) {
        Path filePath = createOrGetFolder();

        String publicFileName = "";
        String originalFilename = file.getOriginalFilename();
        if (originalFilename != null) {
            publicFileName = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));
        }
        Files.copy(file.getInputStream(), filePath.resolve(publicFileName));

        Product product = new Product();
        product.setBaseUrl(FILE_URL_BASE);
        product.setBasePath(FILE_PATH_BASE);
        product.setDynamicPath("/" + getDate() + "/" + publicFileName);
        product.setPublicId(publicFileName);
        product.setName(file.getOriginalFilename());

        return product;
    }

    @SneakyThrows
    @Transactional
    public Product save2(MultipartFile file) {
        Path filePath = createOrGetFolder();

        String publicFileName = "";
        String originalFilename = file.getOriginalFilename();
        if (originalFilename != null) {
            publicFileName = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));
        }
        Files.copy(file.getInputStream(), filePath.resolve(publicFileName));

        Product product = new Product();
        product.setBaseUrl(FILE_URL_BASE);
        product.setBasePath(FILE_PATH_BASE);
        product.setDynamicPath("/" + getDate() + "/" + publicFileName);
        product.setPublicId(publicFileName);
        product.setName(file.getOriginalFilename());

        return product;
    }



    public ResponseEntity downloadFile(String dynamicPath) {
        String filePath = checkIfExistAndBuildFilePathByDynamicPath(dynamicPath);

        File file = new File(filePath);

        InputStreamResource resource = null;
        try {
            resource = new InputStreamResource(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + dynamicPath + "\"");

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

    private String checkIfExistAndBuildFilePathByDynamicPath(String dynamicPath) {
        if (!StringUtils.hasText(dynamicPath)) {
            throw new GeneralException("Invalid document path");
        }

        Optional<Product> optionalProduct = productRepository.getProductByDynamicPath(dynamicPath);

        if (optionalProduct.isPresent()) {
            return optionalProduct.get().getBasePath() + "/" + optionalProduct.get().getDynamicPath();
        } else {
            throw new GeneralException("Product not found by given dynamic path:" + dynamicPath);
        }
    }

    public Page<ProductPageableDto> findProductsWithPagination(Pageable pageable, ProductSearch productSearch) {
        if (productSearch.getSapCode() == null) {
            productSearch.setSapCode("");
        }
        if (productSearch.getProductBarcode() == null) {
            productSearch.setProductBarcode("");
        }
        if (productSearch.getLocations() == null){
            productSearch.setLocations("");
        }
        if (productSearch.getOldBarcode() == null) {
            productSearch.setOldBarcode("");
        }
        if (productSearch.getProductGroup() == null) {
            productSearch.setProductGroup("");
        }
        if (productSearch.getProductSubGroup() == null) {
            productSearch.setProductSubGroup("");
        }
        if (productSearch.getProductSubGroupDetail() == null) {
            productSearch.setProductSubGroupDetail("");
        }
        if (productSearch.getProductLastDetail() == null) {
            productSearch.setProductLastDetail("");
        }
        if (productSearch.getLocation() == null) {
            productSearch.setLocation("");
        }
        if (productSearch.getSubLocation() == null) {
            productSearch.setSubLocation("");
        }
        if (productSearch.getSubLocationDetail() == null) {
            productSearch.setSubLocationDetail("");
        }
        if (productSearch.getWorker() == null) {
            productSearch.setWorker("");
        }
        if (productSearch.getProductArea() == null){
            productSearch.setProductArea("");
        }

        Page<Product> products = productRepository.findAllPageable(productSearch.getSapCode(),
                productSearch.getProductBarcode(), productSearch.getLocations(), productSearch.getOldBarcode(),
                productSearch.getProductGroup(), productSearch.getProductSubGroup(), productSearch.getProductSubGroupDetail(), productSearch.getProductLastDetail(),
                productSearch.getLocation(), productSearch.getSubLocation(), productSearch.getSubLocationDetail(), productSearch.getWorker(),productSearch.getProductArea(), pageable);
        return products.map(ProductMapper::mapToPageable);

    }

}
