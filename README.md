
# Backend Challenge

Projede Company (Şirket) ve Employee (Çalışan) isimli iki sınıf bulunmaktadır. Şirketlerin birden çok çalışanı bulunabilir ancak bir çalışan yalnızca tek bir şirkette çalışabilmektedir.

#### Kullanılan Teknolojiler

* Java Spring Boot
* MySQL 
* Swagger

```http
  src/main/resources/application.properties
```
Yukarıda verilen dizinde bulunan application.properties dosyasında local database kurulumu için gerekli olan kısımlar (db username, db password, db url) doldurulduktan sonra projeyi çalıştırabilirsiniz.
 
```http
http://localhost:8080/swagger-ui/index.html
```
Tarayıcıdan yukarıda verilen adrese gidilirse Swagger arayüzü sayesinde API endpointleri test edilebilir.

![SwaggerUI](https://github.com/regaipaydogdu/backend-challenge/blob/main/screenshot/swaggerui.png?text=App+Screenshot+Here)




## API Kullanımı

Content-Type: application/json

#### Tüm şirket bilgilerini getir

```http
GET /v1/company
```
#### Response
```http
[
    {
        "name": "Apple"
    },
    {
        "name": "Samsung"
    }
]
```
#### İsmi verilen şirketi getir

```http
GET /v1/company/${name}
```

| Parametre | Tip     | Açıklama                       |
| :-------- | :------- | :-------------------------------- |
| `name`      | `String` | **Gerekli**. Çağrılacak öğenin name değeri |

#### Response
```http
{
    "name": "Apple"
}  
```

#### İsmi verilen şirketi oluştur

```http
POST /v1/company/
```

| Parametre | Tip     | Açıklama                       |
| :-------- | :------- | :-------------------------------- |
| `name`      | `String` | **Gerekli**. Oluşturulacak öğenin name değeri |

#### Response
```http
{
    "name": "Samsung"
}  
```
#### ID'si verilen şirketi güncelle

```http
PUT /v1/company/${id}
```

| Parametre | Tip     | Açıklama                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Long` | **Gerekli**. Güncellenecek öğenin id değeri |
| `name`      | `String` | **Gerekli**. Güncellenecek öğenin name değeri |

#### Response
```http
{
    "name": "Apple INC"
}  
```
#### ID'si verilen şirketi sil

```http
DELETE /v1/company/${id}
```

| Parametre | Tip     | Açıklama                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Long` | **Gerekli**. Silinecek öğenin id değeri |


#### Response
```http
Company deleted successfully 
```
#### Tüm Çalışan bilgilerini getir

```http
GET /v1/employee
```
#### Response
```http
[
  {
    "firstName": "Lionel",
    "lastName": "Messi",
    "identityNumber": 12345,
    "companyName": "Apple"
  },
  {
    "firstName": "Cristiano",
    "lastName": "Ronaldo",
    "identityNumber": 54123,
    "companyName": "Samsung"
  }
]
```
#### İsmi verilen çalışanı getir

```http
GET /v1/employee/${identityNumber}
```

| Parametre | Tip     | Açıklama                       |
| :-------- | :------- | :-------------------------------- |
| `identityNumber`      | `Long` | **Gerekli**. Çağrılacak öğenin identityNumber değeri |

#### Response
```http
{
  "firstName": "Lionel",
  "lastName": "Messi",
  "identityNumber": 12345,
  "companyName": "Apple"
}  
```

#### Çalışan oluştur

```http
POST /v1/employee/
```

| Parametre | Tip     | Açıklama                       |
| :-------- | :------- | :-------------------------------- |
| `firstName`      | `String` | **Gerekli**. Oluşturulacak öğenin firstName değeri |
| `lastName`      | `String` | **Gerekli**. Oluşturulacak öğenin lastName değeri |
| `identityNumber`      | `Long` | **Gerekli**. Oluşturulacak öğenin identityNumber değeri |
| `companyId`      | `Long` | **Gerekli**. Oluşturulacak öğenin companyId değeri |

#### Response
```http
{
  "firstName": "Lionel",
  "lastName": "Messi",
  "identityNumber": 12345,
  "companyName": "Apple"
} 
```
#### ID'si verilen çalışanı güncelle

```http
PUT /v1/employee/${id}
```

| Parametre | Tip     | Açıklama                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Long` | **Gerekli**. Güncellenecek öğenin id değeri |
| `firstName`      | `String` | **Gerekli**. Oluşturulacak öğenin firstName değeri |
| `lastName`      | `String` | **Gerekli**. Oluşturulacak öğenin lastName değeri |
| `identityNumber`      | `Long` | **Gerekli**. Oluşturulacak öğenin identityNumber değeri |
| `companyId`      | `Long` | **Gerekli**. Oluşturulacak öğenin companyId değeri |

#### Response
```http
{
  "firstName": "Leo",
  "lastName": "Messi",
  "identityNumber": 12345,
  "companyName": "Apple"
}  
```
#### ID'si verilen çalışanı sil

```http
DELETE /v1/employee/${id}
```

| Parametre | Tip     | Açıklama                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Long` | **Gerekli**. Silinecek öğenin id değeri |


#### Response
```http
Employee deleted successfully 
```

  
