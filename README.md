# TunahanBank
Spring Boot


 
 1-) Müşteri (Customer)
 
    id(tckn)
    name
    dateOfBirth(year)
    city
    address	
    
 
 2-) Hesap (Account)
     
     id
     customerId
     balance (bakiye)
     city
     currency (para birimi)
     
     
  ### Customer CRUD   - CustomerAPI

- Create, Read, Update, Delete 

     
   ### Account CRUD    - AccountAPI

- Create, Read, Update, Delete

- Withdraw Money ( Para çekmek)

- Add Money


API : HTTP isteklerini karşılayıp gerekli yerlere aktarır. İşlemin sonucunu yine bu HTTP üzerinden kullanıcıya geri döner.

localhost:8080 -> Tomcat, uygulamamızı (JAR dosyası ) çalıştırdı ve dış dünyaya (HTTP) açtı.


  ### HTTP REQUEST TYPES
  
  GET    -> Veri alma isteği    --> 200 - OK
  
  POST   -> Veri ekleme isteği  --> 202 - CREATED
  
  PUT    -> Veri güncelleme isteği
  
  DELETE -> Veri silme isteği
  
  
  
  ResponseEntity -> Json tipinde String dizisi döner. Controller paketinde kullanılır.
  
  @RequestBody    -> Post metodunda aldığı Json formatını bizim tanımlayacağımız objeye dönüştürür.
  
  @PathVariable   -> URL'den gelen değeri bir parametreye atar.
  
  
  CustomerDTO : Dönüş değeri
  
  CreateCustomerRequest : API fonksiyonun almış olduğu parametre.
  
  
  @Service dediğim zaman ilgili servisi controller dan inject edebiliyorum. Controller, Service'in sadece referansını alır.
  
  @Id  kullanarak aynı id ile defalarca veri kaydetmenin önüne geçeriz. Aynı id geldiği zaman güncelleme gerçekleştirir.
  
  
  ### CustomerService
  
  -createCustomer
  -getAllCustomer
  -getCustomer
  -updateCustomer
  -deleteCustomer
  
  
  ## @Service @Component Farkı Nedir ?
  
  Bulunduğum sınıftan başka bir katmana erişmek istersem @Service (Başka katmanlara gider)
  Başka bir katmandan bulunduğum sınıfa erişmek için @Component   (Katmanlardan buraya gelir)
  @Componet ,  @Service gibi inject edilebilir. @Service ile aynı özellikleri taşır.
  
  
