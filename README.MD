ENDS POINT FOR THE PRODUCT-APPLICATION :
----------------------------------------
1.
METHOD    : POST
PURPOSE   : TO STORE THE PRODUCT DETAILS
END POINT : http://localhost:8080/api/product
BODY      :
{
    "pid":1001,
    "pname":"smart phone",
    "price":5000
}
2.
METHOD    : GET
PURPOSE   : TO GET ALL THE PRODUCTS DETAILS
END POINT : http://localhost:8080/api/product

3.
METHOD    : GET
PURPOSE   : TO GET THE SPECIFIC PRODUCT BASED ON ID
END POINT : http://localhost:8080/api/product/1001

4.

METHOD    : DELETE
PURPOSE   : TO DELETE THE SPECIFIC PRODUCT BASED ON ID
END POINT : http://localhost:8080/api/product/1001


5.
METHOD    : PUT
PURPOSE   : TO UPDATE THE SPECIFIC  PRODUCT BASED ON ID
END POINT : http://localhost:8080/api/product

===================================***=============================


IN ORDER TO TEST WITH SWAGGER DOCUMENATION USE THE FOLLOWING URL:

http://localhost:8080/swagger-ui.html

