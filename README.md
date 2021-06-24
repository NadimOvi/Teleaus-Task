# Teleaus-Task
TeleAus interview assessment test

# Retrofit
This app shows a list of users details using RESTFUL API. I’m using Retrofit Library for integrate to the API service.
# Add the retrofit dependency

Firstly, Add Internet Permission to the Application in **AndroidManifest.xml,**
`<uses-permission android:name="android.permission.INTERNET"></uses-permission>`
Then, We have to add the retrofit dependency into our build.grade file. We can find the latest retrofit version on the official retrofit website. > http://square.github.io/retrofit/

```
 implementation 'com.squareup.retrofit2:retrofit:2.6.0'
 implementation 'com.squareup.retrofit2:converter-gson:2.6.0'
```
We have also add add some extra library

```
    implementation 'androidx.recyclerview:recyclerview:1.2.1'
    implementation 'androidx.cardview:cardview:1.0.0'
    implementation 'com.squareup.picasso:picasso:2.71828'
    implementation 'de.hdodenhof:circleimageview:2.2.0'
    implementation 'org.parceler:parceler-api:1.1.12'
    annotationProcessor 'org.parceler:parceler:1.1.12'
    implementation 'com.github.bumptech.glide:glide:4.1.1'
    implementation 'com.android.support:support-v4:29.3.1'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.1.1'
```
# Creating the Model Class
In order for Retrofit to extract data from a request. We need to make a model class to store the information in. This is not strictly required, and we could technically just get the raw response back, but storing the information in a model class and making it more easily accessible is one of the areas where Retrofit shines.
Let's look at the reponse we get from running a GET request on a user's followers, specifically:

```https://talenttorrent.com/api/v1/experts```
We get a list of users back in the form of JSON objects:
```
{
    "success": true,
    "data": [
        {
            "id": 2,
            "first_name": "Mustaque",
            "last_name": "Ahemmed",
            "email": "hellomstq@gmail.com",
            "username": "hellomustaq",
            "type": "expert",
            "profile": {
                "id": 2,
                "is_public": 1,
                "avatar_url": "https://talenttorrent.com/images/talents/placeholder.png",
                "cover_photo_url": "https://talenttorrent.com/images/talents/cover.jpg",
                "date_of_birth": null,
                "qualification": "bachelor",
                "experience": "2",
                "skills": [
                    "PHP",
                    "PYTHON"
                ],
                "business_number": null,
                "cover_letter": "Software Engineer",
                "job_title": null,
                "company_name": "HelloIT",
                "company_size": "1-20",
                "business_type": "HelloIT",
                "company_registration_number": "HelloIT",
                "location": "Dhaka",
                "country": "Bangladesh",
                "created_at": "2019-11-08T06:56:08.000000Z",
                "updated_at": "2020-06-11T10:37:23.000000Z"
            },
            "verified_at": "2019-11-14 03:39:25",
            "created_at": "08 Nov, 2019",
            "updated_at": "2021-06-17T10:19:15.000000Z"
        }
    ],
    "meta": {
        "last_page": 2,
        "next_page_url": "https://talenttorrent.com/api/v1/experts?page=2",
        "prev_page_url": null,
        "total": 29
    }
       
}
```
Therefore, we create several kinds of Model class. Afterthat convert to the json data and display to the MAIN UI.
# Demo
![WhatsApp Image 2021-06-24 at 10 51 44 AM](https://user-images.githubusercontent.com/32881847/123204977-e67f6600-d4da-11eb-8570-e324d9d61613.jpeg) ![WhatsApp Image 2021-06-24 at 10 54 09 AM](https://user-images.githubusercontent.com/32881847/123205075-12025080-d4db-11eb-96b1-bc57b90e0915.jpeg)



