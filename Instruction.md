Basic Setup & Installation
------------------

To develop app you need to set up an Android studio.

### Android Studio Setup Process

-   Download Android Studio - [https://developer.android.com/studio/](https://developer.android.com/studio/)
-   Install Android Studio - [https://developer.android.com/studio/install](https://developer.android.com/studio/install)
-   Learn more about Android Studio - [https://developer.android.com/studio/intro/](https://developer.android.com/studio/intro/)

Android App Configuration
-------------------------

### Open project in Android studio

**Step 1:-** Select ‘Import Project’ option and find your **“Woobox\_droid" Project**

![](https://github.com/vaibhavhariaramani/Ecommerce-Android-App/blob/master/images/1.png)

**Step 2:-** Select your current project then click ok button and wait few minute

![](https://github.com/vaibhavhariaramani/Ecommerce-Android-App/blob/master/images/2.png)

### Change ApplicationID

- Find build.gradle file inside app folder and click to open and change your **applicationId**

![howtochangeappid](https://github.com/vaibhavhariaramani/Ecommerce-Android-App/blob/master/images/3.png)

### Change Application menu icon, background and app icon

- Open res folder inside open **all drawable folder** and **all mipmap folder** and replace your background images and icons here.

![](https://github.com/vaibhavhariaramani/Ecommerce-Android-App/blob/master/images/4.png)

### Change Application name

- Open app gradle file and change your **'app\_name'** here

![](https://github.com/vaibhavhariaramani/Ecommerce-Android-App/blob/master/images/5.png)

### Change app Font

- Click and open font folder and change ttf file

![](https://github.com/vaibhavhariaramani/Ecommerce-Android-App/blob/master/images/6.png)

- Open String.xml file and change font string value

![](https://github.com/vaibhavhariaramani/Ecommerce-Android-App/blob/master/images/11.png)

### Change color

- Open color.xml file and change colors

![](https://github.com/vaibhavhariaramani/Ecommerce-Android-App/blob/master/images/7.png)

### Change Admob ID

- Open string.xml file and change admob\_app\_id and ad\_mob\_banner\_id String value

![](https://github.com/vaibhavhariaramani/Ecommerce-Android-App/blob/master/images/8.png)

### Change server URL

- Open Constants.kt file

![](https://github.com/vaibhavhariaramani/Ecommerce-Android-App/blob/master/images/9.png)

### Change Token

- Open Constants file from utils package and change consumerKey, consumerSecret, token and tokenSecret

![](https://github.com/vaibhavhariaramani/Ecommerce-Android-App/blob/master/images/12.png)

### Change Dashboard

- For changing Dashboard design of your choice,you have to chane some code into DashboardActivity.kt.You have to initialize mHomeFragment="YOUR DESIRED HOME FRAGMENT"()

![](https://github.com/vaibhavhariaramani/Ecommerce-Android-App/blob/master/images/13.png)

Push Notification
-----------------

### Create a Firebase Project

The first step is to create a project in the Google environment.

Note: You need to have been logged in with a Google account which can use the Firebase console in order to walk through this tutorial.

You create a project with the Firebase console.

Follow the steps below to create new project.

-   Open the [Firebase console](https://console.firebase.google.com/?pli=1).
-   Click "Add Project" and follow the steps upto creation of project. ![](https://github.com/vaibhavhariaramani/Ecommerce-Android-App/blob/master/images/Firebase1.png)
     ![](https://github.com/vaibhavhariaramani/Ecommerce-Android-App/blob/master/images/Firebase3.png)
-   After creation of project your screen looks like below. ![](https://github.com/vaibhavhariaramani/Ecommerce-Android-App/blob/master/images/Firebase4.png)
-   Add Firebase to your Android app. Also download json file for future refrences. ![](https://github.com/vaibhavhariaramani/Ecommerce-Android-App/blob/master/images/Firebase4.png)
     ![](https://github.com/vaibhavhariaramani/Ecommerce-Android-App/blob/master/images/Firebase5.png)
     ![](https://github.com/vaibhavhariaramani/Ecommerce-Android-App/blob/master/images/Firebase7.png)
     ![](https://github.com/vaibhavhariaramani/Ecommerce-Android-App/blob/master/images/Firebase8.png)

### Configure Firebase on App

We have already added code for sdk and other configuration for firebase.

You just enable some codes if you are want firebase support on your app

![](https://github.com/vaibhavhariaramani/Ecommerce-Android-App/blob/master/images/FirebaseEnable1.png)
 ![](https://github.com/vaibhavhariaramani/Ecommerce-Android-App/blob/master/images/FirebaseEnable2.png)
 ![](https://github.com/vaibhavhariaramani/Ecommerce-Android-App/blob/master/images/FirebaseEnable3.png)

Update your google-services.json file

![](https://github.com/vaibhavhariaramani/Ecommerce-Android-App/blob/master/images/FirebaseEnable4.png)

### Create New Account on OneSignal

OneSignal is used for send push notification into mobile and web. Fore more details about [OneSignal](https://onesignal.com/)

If you have own OneSignal then login and create project. If you does not have then register your account and create new project.

You create a project with the OneSignal.

![](https://github.com/vaibhavhariaramani/Ecommerce-Android-App/blob/master/images/OneSignal1.png)
 ![](https://github.com/vaibhavhariaramani/Ecommerce-Android-App/blob/master/images/OneSignal2.png)
 ![](https://github.com/vaibhavhariaramani/Ecommerce-Android-App/blob/master/images/OneSignal3.png)
 ![](https://github.com/vaibhavhariaramani/Ecommerce-Android-App/blob/master/images/OneSignal4.png)

Goto Firebase app and copy your Firebase server key and Firebase sender id.

![](https://github.com/vaibhavhariaramani/Ecommerce-Android-App/blob/master/images/Firebase9.png)
 ![](https://github.com/vaibhavhariaramani/Ecommerce-Android-App/blob/master/images/Firebase10.png)

Follow the steps until your project is not ready.

### Configure OneSignal on App

We have already added code for sdk and other configuration for onesingal push notification. You have to change your onesignal app id

![](https://github.com/vaibhavhariaramani/Ecommerce-Android-App/blob/master/images/OnesignalAppId.png)

Also Enable some codes if you are want onesignal support on your app

![](https://github.com/vaibhavhariaramani/Ecommerce-Android-App/blob/master/images/on1.png)
 ![](https://github.com/vaibhavhariaramani/Ecommerce-Android-App/blob/master/images/on2.png)
 ![](https://github.com/vaibhavhariaramani/Ecommerce-Android-App/blob/master/images/on3.png)
 ![](https://github.com/vaibhavhariaramani/Ecommerce-Android-App/blob/master/images/on4.png)
 ![](https://github.com/vaibhavhariaramani/Ecommerce-Android-App/blob/master/images/on5.png)

### Send Push Notification

To send push notificaiton you need to follow below steps

![](https://github.com/vaibhavhariaramani/Ecommerce-Android-App/blob/master/images/PushNotification1.png)
 ![](https://github.com/vaibhavhariaramani/Ecommerce-Android-App/blob/master/images/PushNotification2.png)

If you want to show image on push notification then select below option with your image url

![](https://github.com/vaibhavhariaramani/Ecommerce-Android-App/blob/master/images/PushNotification3.png)

If you want to open some url when user click on notificaiton then select below option with custom key "webUrl"

NOTE: Compulsory Key is "webUrl"

![](https://github.com/vaibhavhariaramani/Ecommerce-Android-App/blob/master/images/PushNotification4.png)
 ![](https://github.com/vaibhavhariaramani/Ecommerce-Android-App/blob/master/images/PushNotification5.png)
 ![](https://github.com/vaibhavhariaramani/Ecommerce-Android-App/blob/master/images/PushNotification6.png)
