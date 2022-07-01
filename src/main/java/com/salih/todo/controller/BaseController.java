package com.salih.todo.controller;

public abstract class BaseController {
    static final String API = "/api";
    static final String AUTH = API + "/auth";
    static final String PUBLIC = API + "/public";

    //version
    static final String VERSION = PUBLIC + "/mobileMajorVersion";

    //auth
    static final String AUTH_LOGIN = AUTH + "/login";
    static final String AUTH_LOGOUT = AUTH + "/logout";
    static final String AUTH_REGISTER = AUTH + "/register";
    static final String AUTH_REFRESH_TOKEN = AUTH + "/refreshtoken";
    static final String PUBLIC_AUTH_DELETE = PUBLIC + "/auth/delete";
    static final String PUBLIC_AUTH_GETALL = PUBLIC + "/auth/getAll";
    static final String PUBLIC_AUTH_UPDATE = PUBLIC + "/auth/update";
    static final String PUBLIC_AUTH_SAVE = PUBLIC + "/auth/save";

    //product
    static final String PUBLIC_FIND_ALL_PRODUCT = PUBLIC + "/product/getAll";
    static final String PUBLIC_SAVE_PRODUCT = PUBLIC + "/product/save";
    static final String PUBLIC_DELETE_PRODUCT = PUBLIC + "/product/delete";
    static final String PUBLIC_UPDATE_PRODUCT = PUBLIC + "/product/update";
    static final String PUBLIC_PRODUCT_PAGEABLE = PUBLIC + "/product/pageable";
    static final String PUBLIC_PRODUCT_WEB_SAVE = PUBLIC + "/product/saveWeb";
    static final String PUBLIC_PRODUCT_IMAGE = PUBLIC + "/product/image";

    //products
    static final String PRODUCTS_GETALL = PUBLIC + "/products/getAll";
    static final String PRODUCTS_SAVE = PUBLIC + "/products/save";
    static final String PRODUCTS_DELETE = PUBLIC + "/products/delete";
    static final String PRODUCTS_UPDATE = PUBLIC + "/products/update";
    static final String PRODUCTS_PAGEABLE = PUBLIC + "/products/pageable";

    //productArea
    static final String PUBLIC_FIND_ALL_PRODUCT_AREA = PUBLIC + "/productarea/getAll";
    static final String PUBLIC_SAVE_PRODUCT_AREA = PUBLIC + "/productarea/save";
    static final String PUBLIC_DELETE_PRODUCT_AREA = PUBLIC + "/productarea/delete";

    //colour
    static final String PUBLIC_FIND_ALL_COLOUR = PUBLIC + "/colour/getAll";
    static final String PUBLIC_SAVE_COLOUR = PUBLIC + "/colour/save";
    static final String PUBLIC_DELETE_COLOUR = PUBLIC + "/colour/delete";

    //numberPlate
    static final String PUBLIC_FIND_ALL_NUMBER_PLATE = PUBLIC + "/numberplate/getAll";
    static final String PUBLIC_SAVE_NUMBER_PLATE = PUBLIC + "/numberplate/save";
    static final String PUBLIC_DELETE_NUMBER_PLATE = PUBLIC + "/numberplate/delete";

    //worker
    static final String PUBLIC_FIND_ALL_WORKER = PUBLIC + "/worker/getAll";
    static final String PUBLIC_SAVE_WORKER = PUBLIC + "/worker/save";
    static final String PUBLIC_DELETE_WORKER = PUBLIC + "/worker/delete";
    static final String PUBLIC_UPDATE_WORKER = PUBLIC + "/worker/update";
    static final String PUBLIC_WORKER_PAGEABLE = PUBLIC + "/worker/pageable";
    static final String PUBLIC_WORKER_FILTER = PUBLIC + "/worker/filter";

    //subLocationDetail
    static final String PUBLIC_FIND_ALL_SUBLOCATIONDETAIL = PUBLIC + "/sublocationdetail/getAll";
    static final String PUBLIC_SAVE_SUBLOCATIONDETAIL = PUBLIC + "/sublocationdetail/save";
    static final String PUBLIC_DELETE_SUBLOCATIONDETAIL = PUBLIC + "/sublocationdetail/delete";
    static final String PUBLIC_UPDATE_SUBLOCATIONDETAIL = PUBLIC + "/sublocationdetail/update";
    static final String PUBLIC_GET_BY_SUBLOCATIN_ID = PUBLIC + "/sublocationdetail";
    static final String PUBLIC_SUBLOCATIONDETAIL_SEARCH = PUBLIC + "/sublocationdetail/pageable";

    //subLocation
    static final String PUBLIC_FIND_ALL_SUBLOCATION = PUBLIC + "/sublocation/getAll";
    static final String PUBLIC_SAVE_SUBLOCATION = PUBLIC + "/sublocation/save";
    static final String PUBLIC_DELETE_SUBLOCATION = PUBLIC + "/sublocation/delete";
    static final String PUBLIC_UPDATE_SUBLOCATION = PUBLIC + "/sublocation/update";
    static final String PUBLIC_GET_BY_LOCATION_ID_SUBLOCATION = PUBLIC + "/sublocation";
    static final String PUBLIC_SUBLOCATIN_SEARCH = PUBLIC + "/sublocation/pageable";

    //location
    static final String PUBLIC_FIND_ALL_LOCATION = PUBLIC + "/location/getAll";
    static final String PUBLIC_SAVE_LOCATION = PUBLIC + "/location/save";
    static final String PUBLIC_DELETE_LOCATION = PUBLIC + "/location/delete";
    static final String PUBLIC_UPDATE_LOCATION = PUBLIC + "/location/update";
    static final String PUBLIC_GET_BY_LOCATION_ID = PUBLIC + "/location";
    static final String PUBLIC_LOCATION_SEARCH = PUBLIC + "/location/pageable";

    //productLastDetail
    static final String PUBLIC_FIND_ALL_PRODUCTLASTDETAIL = PUBLIC + "/productlastdetail/getAll";
    static final String PUBLIC_SAVE_PRODUCTLASTDETAIL = PUBLIC + "/productlastdetail/save";
    static final String PUBLIC_DELETE_PRODUCTLASTDETAIL = PUBLIC + "/productlastdetail/delete";
    static final String PUBLIC_UPDATE_PRODUCTLASTDETAIL = PUBLIC + "/productlastdetail/update";
    static final String PUBLIC_GET_BY_PRODUCTSUBGROUPDETAIL_ID= PUBLIC +"/productlastdetail";
    static final String PUBLIC_PRODUCTLASTDETAIL_PAGEABLE = PUBLIC + "/productlastdetail/pageable";

    //productSubGroupDetail
    static final String PUBLIC_FIND_ALL_PRODUCTSUBGROUPDETAIL = PUBLIC + "/productsubgroupdetail/getAll";
    static final String PUBLIC_SAVE_PRODUCTSUBGROUPDETAIL = PUBLIC + "/productsubgroupdetail/save";
    static final String PUBLIC_DELETE_PRODUCTSUBGROUPDETAIL = PUBLIC + "/productsubgroupdetail/delete";
    static final String PUBLIC_UPDATE_PRODUCTSUBGROUPDETAIL = PUBLIC + "/productsubgroupdetail/update";
    static final String PUBLIC_GET_BY_PRODUCTSUBGROUP_ID = PUBLIC + "/productsubgroupdetail";
    static final String PUBLIC_PRODUCTSUBGROUPDETAIL_PAGEABLE = PUBLIC + "/productsubgroupdetail/pageable";

    //productSubGroup
    static final String PUBLIC_FIND_ALL_PRODUCTSUBGROUP = PUBLIC + "/productsubgroup/getAll";
    static final String PUBLIC_SAVE_PRODUCTSUBGROUP = PUBLIC + "/productsubgroup/save";
    static final String PUBLIC_DELETE_PRODUCTSUBGROUP = PUBLIC + "/productsubgroup/delete";
    static final String PUBLIC_UPDATE_PRODUCTSUBGROUP = PUBLIC + "/productsubgroup/update";
    static final String PUBLIC_GET_BY_PRODUCTGROUP_ID = PUBLIC + "/productsubgroup";
    static final String PUBLIC_PRODUCTSUBGROUP_PAGEABLE = PUBLIC + "/productsubgroup/pageable";

    //productGroup
    static final String PUBLIC_FIND_ALL_PRODUCTGROUP = PUBLIC + "/productgroup/getAll";
    static final String PUBLIC_SAVE_PRODUCTGROUP = PUBLIC + "/productgroup/save";
    static final String PUBLIC_DELETE_PRODUCTGROUP = PUBLIC + "/productgroup/delete";
    static final String PUBLIC_UPDATE_PRODUCTGROUP = PUBLIC + "/productgroup/update";
    static final String PUBLIC_PRODUCTGROUP_PAGEABLE = PUBLIC + "/productgroup/pageable";
    static final String PUBLIC_FIND_BYID_PRODUCTAREA = PUBLIC + "/productgroup";

    //log
    static final String PUBLIC_SAVE_LOG = PUBLIC + "/log/saveLog";
    static final String GET_ALL_LOGS = API + "/log/getAll";

    //response time
    static final String PUBLIC_CONTROL_RESPONSE_TIME = PUBLIC + "/responseTime/control";

    //file
    static final String API_DOWNLOAD_FILE = PUBLIC + "/file";
    static final String API_SAVE_FILE = PUBLIC + "/file/save";


}
