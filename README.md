# Цветочный магазин
## Описание

Сайт разработан с использованием Java 11, Spring Framework и Hibernate. 

## Products
**GET** /api - возвращает список из топ-12 товаров 

Response body - json
```
[
    {
        "productName": "Розовый туман",
        "productPrice": 2590
    },
    {
        "productName": "Violet",
        "productPrice": 2190
    },
    {
        "productName": "Невесомость",
        "productPrice": 2190
    },
    {
        "productName": "Романтика",
        "productPrice": 3790
    },
    {
        "productName": "Попурри",
        "productPrice": 3300
    },
    {
        "productName": "Мистерия",
        "productPrice": 2090
    },
    {
        "productName": "Jam",
        "productPrice": 2090
    },
    {
        "productName": "Мэрилин Монро",
        "productPrice": 2190
    },
    {
        "productName": "Нежное послание",
        "productPrice": 1890
    },
    {
        "productName": "Розовый микс",
        "productPrice": 2890
    },
    {
        "productName": "Miss",
        "productPrice": 2290
    },
    {
        "productName": "Калейдоскоп",
        "productPrice": 2590
    }
]
```

**GET** /api/catalog - возвращает список всех товаров

**GET** /api/catalog/{category} -  возвращает список товаров по категории

## Order 
**POST** /api/order - создает новый заказ

Request body - json
```
{
  "customerName": "Никита",
  "customerMobile": "88005553535",
  "receiverName": "Полина",
  "receiverMobile": "89003335545",
  "postcardText": "С др",
  "commentsToOrder": "код домофона: 111",
  "deliveryAddress": "Саратов",
  "deliveryDate": "20.06.2024",
  "deliveryTime": "15:00-17:00",
  "deliveryIncluded": true,
  "totalPrice": 10950,
  "cartItems": [
    {
      "productId": 1,
      "quantity": 3
    },
    {
      "productId": 2,
      "quantity": 2
    }
  ]
}
```

Response body
```
Code 200: OK
```


