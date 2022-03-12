# 🚧corona-android

Corona Android Application

## About this Project

### Introduction

### Function

## How to use

### Prerequisites

1. requires Firebase project [Site](https://console.firebase.google.com/?hl=ko)

2. requires local server [Github](https://github.com/nogardj3/server_nodejs.git)

### Installation

1. Clone the repo

   ```sh
   git clone https://github.com/nogardj3/server_nodejs
   ```

2. Copy google-services.json to ./app

   ```sh
   cp your_service_account_key.json ./app/google-services.json
   ```

3. add key to local.properties

   ```
   admob_app_id = ""
   admob_banner_id = ""
   google_map_key = ""
   ```

4. add server url to values/string.xml

   ```xml
   <string name="server_url">http://10.0.2.2:4000/chef/</string>
   ```

## Tech stack & Open-source libraries

- [Kotlin(Coroutine, Flow)](https://developer.android.com/kotlin/coroutines?hl=ko)
- [AAC(Databinding, Lifecycle, Livedata, ViewModel, Room, Navigation)](https://developer.android.com/topic/libraries/architecture?hl=ko)
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android?hl=ko)
- [Junit, Mockito](https://developer.android.com/training/testing/unit-testing/local-unit-tests?hl=ko)
- [Firebase(Auth, Admob, Analytics, Crashlytics, Cloud Messaging, Storage)](https://firebase.google.com/docs?hl=ko)
- [RxJava3](http://reactivex.io/)
- [Retrofit2](https://square.github.io/retrofit/)
- [Glide V4](https://github.com/bumptech/glide)
