[**E-shopping App**Docs](https://github.com/vaibhavhariaramani/Ecommerce-Android-App/master/readme1.md)
=========================================================================================================================================================

-   [Home](https://github.com/vaibhavhariaramani/Ecommerce-Android-App/)
-
-   [Try Demo](https://play.google.com/store/apps/details?id=com.iqonic.woobox)

### “ E-shopping - Native Android App for E-Commerce”

Created: 17/05/2029
 Updated: 26/06/2020
 Email: [vaibhav.hariramani01@gmail.com](mailto:vaibhav.hariramani01@gmail.com)


Basic Installation
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

![](https://github.com/vaibhavhariaramani/Ecommerce-Android-App/tree/master/images/1.png)

**Step 2:-** Select your current project then click ok button and wait few minute

![HTML Structure](./WooBox%20-%20Native%20Android%20App%20for%20WooCommerce_files/2.png)

### Change ApplicationID

- Find build.gradle file inside app folder and click to open and change your **applicationId**

![howtochangeappid](./WooBox%20-%20Native%20Android%20App%20for%20WooCommerce_files/3.png)

### Change Application menu icon, background and app icon

- Open res folder inside open **all drawable folder** and **all mipmap folder** and replace your background images and icons here.

![HTML Structure](./WooBox%20-%20Native%20Android%20App%20for%20WooCommerce_files/4.png)

### Change Application name

- Open app gradle file and change your **'app\_name'** here

![HTML Structure](./WooBox%20-%20Native%20Android%20App%20for%20WooCommerce_files/5.png)

### Change app Font

- Click and open font folder and change ttf file

![HTML Structure](./WooBox%20-%20Native%20Android%20App%20for%20WooCommerce_files/6.png)

- Open String.xml file and change font string value

![HTML Structure](./WooBox%20-%20Native%20Android%20App%20for%20WooCommerce_files/11.png)

### Change color

- Open color.xml file and change colors

![HTML Structure](./WooBox%20-%20Native%20Android%20App%20for%20WooCommerce_files/7.png)

### Change Admob ID

- Open string.xml file and change admob\_app\_id and ad\_mob\_banner\_id String value

![HTML Structure](./WooBox%20-%20Native%20Android%20App%20for%20WooCommerce_files/8.png)

### Change server URL

- Open Constants.kt file

![HTML Structure](./WooBox%20-%20Native%20Android%20App%20for%20WooCommerce_files/9.png)

### Change Token

- Open Constants file from utils package and change consumerKey, consumerSecret, token and tokenSecret

![HTML Structure](./WooBox%20-%20Native%20Android%20App%20for%20WooCommerce_files/12.png)

### Change Dashboard

- For changing Dashboard design of your choice,you have to chane some code into DashboardActivity.kt.You have to initialize mHomeFragment="YOUR DESIRED HOME FRAGMENT"()

![HTML Structure](./WooBox%20-%20Native%20Android%20App%20for%20WooCommerce_files/13.png)

Push Notification
-----------------

### Create a Firebase Project

The first step is to create a project in the Google environment.

Note: You need to have been logged in with a Google account which can use the Firebase console in order to walk through this tutorial.

You create a project with the Firebase console.

Follow the steps below to create new project.

-   Open the [Firebase console](https://console.firebase.google.com/?pli=1).
-   Click "Add Project" and follow the steps upto creation of project. ![](./WooBox%20-%20Native%20Android%20App%20for%20WooCommerce_files/Firebase1.png)
     ![](./WooBox%20-%20Native%20Android%20App%20for%20WooCommerce_files/Firebase3.png)
-   After creation of project your screen looks like below. ![](./WooBox%20-%20Native%20Android%20App%20for%20WooCommerce_files/Firebase4.png)
-   Add Firebase to your Android app. Also download json file for future refrences. ![](./WooBox%20-%20Native%20Android%20App%20for%20WooCommerce_files/Firebase4.png)
     ![](./WooBox%20-%20Native%20Android%20App%20for%20WooCommerce_files/Firebase5.png)
     ![](./WooBox%20-%20Native%20Android%20App%20for%20WooCommerce_files/Firebase7.png)
     ![](./WooBox%20-%20Native%20Android%20App%20for%20WooCommerce_files/Firebase8.png)

### Configure Firebase on App

We have already added code for sdk and other configuration for firebase.

You just enable some codes if you are want firebase support on your app

![](./WooBox%20-%20Native%20Android%20App%20for%20WooCommerce_files/FirebaseEnable1.png)
 ![](./WooBox%20-%20Native%20Android%20App%20for%20WooCommerce_files/FirebaseEnable2.png)
 ![](./WooBox%20-%20Native%20Android%20App%20for%20WooCommerce_files/FirebaseEnable3.png)

Update your google-services.json file

![](./WooBox%20-%20Native%20Android%20App%20for%20WooCommerce_files/FirebaseEnable4.png)

### Create New Account on OneSignal

OneSignal is used for send push notification into mobile and web. Fore more details about [OneSignal](https://onesignal.com/)

If you have own OneSignal then login and create project. If you does not have then register your account and create new project.

You create a project with the OneSignal.

![](./WooBox%20-%20Native%20Android%20App%20for%20WooCommerce_files/OneSignal1.png)
 ![](./WooBox%20-%20Native%20Android%20App%20for%20WooCommerce_files/OneSignal2.png)
 ![](./WooBox%20-%20Native%20Android%20App%20for%20WooCommerce_files/OneSignal3.png)
 ![](./WooBox%20-%20Native%20Android%20App%20for%20WooCommerce_files/OneSignal4.png)

Goto Firebase app and copy your Firebase server key and Firebase sender id.

![](./WooBox%20-%20Native%20Android%20App%20for%20WooCommerce_files/Firebase9.png)
 ![](./WooBox%20-%20Native%20Android%20App%20for%20WooCommerce_files/Firebase10.png)

Follow the steps until your project is not ready.

### Configure OneSignal on App

We have already added code for sdk and other configuration for onesingal push notification. You have to change your onesignal app id

![](./WooBox%20-%20Native%20Android%20App%20for%20WooCommerce_files/OnesignalAppId.png)

Also Enable some codes if you are want onesignal support on your app

![](./WooBox%20-%20Native%20Android%20App%20for%20WooCommerce_files/on1.png)
 ![](./WooBox%20-%20Native%20Android%20App%20for%20WooCommerce_files/on2.png)
 ![](./WooBox%20-%20Native%20Android%20App%20for%20WooCommerce_files/on3.png)
 ![](./WooBox%20-%20Native%20Android%20App%20for%20WooCommerce_files/on4.png)
 ![](./WooBox%20-%20Native%20Android%20App%20for%20WooCommerce_files/on5.png)

### Send Push Notification

To send push notificaiton you need to follow below steps

![](./WooBox%20-%20Native%20Android%20App%20for%20WooCommerce_files/PushNotification1.png)
 ![](./WooBox%20-%20Native%20Android%20App%20for%20WooCommerce_files/PushNotification2.png)

If you want to show image on push notification then select below option with your image url

![](./WooBox%20-%20Native%20Android%20App%20for%20WooCommerce_files/PushNotification3.png)

If you want to open some url when user click on notificaiton then select below option with custom key "webUrl"

NOTE: Compulsory Key is "webUrl"

![](./WooBox%20-%20Native%20Android%20App%20for%20WooCommerce_files/PushNotification4.png)
 ![](./WooBox%20-%20Native%20Android%20App%20for%20WooCommerce_files/PushNotification5.png)
 ![](./WooBox%20-%20Native%20Android%20App%20for%20WooCommerce_files/PushNotification6.png)

### Support & Assistance

Faced a problem? Need assistance with the product? No worries – our customer support team is always ready to help you.

> -   Support requests are being processed on business days from 9:00 to 18:00 (GMT +05.30) [generally] within 24h to 48h in the order they were received.
> -   We suggest, while our team reviews your support request, please read the documentation that comes in the zip file of Codecanyon. You can download it from ThemeForest: https://codecanyon.net/downloads
> -   We are in GMT+5:30 timezone. We address all the support queries 6 days weekly (Sunday off).
> -   If any support ticket has no response from the item owner for 7 days, the ticket will be considered closed. If you need further assistance you can create another ticket or drop us an email asking to re-open the ticket for you.
> -   Have pre-sales questions or concerns, please write to us via our [website contact page](https://iqonic.design/contact/)
> -   If you like our product and support then please drop a rate and write a review at: https://codecanyon.net/downloads

**Note:**We have launched our support portal on Desky. Please raise a ticket here at https://iqonic.desky.support/

### Refund Policy

-   We don't offer a refund. (If the item is downloaded)
-   Please read the description and compatibility content thoroughly before purchasing as we don't offer a refund if you buy it by mistake.

### Greetings from Iqonic Design

We are actively looking forward to your feedback in order to make our product more efficient for you. Thanks again!

[**Introduction**](https://iqonic.design/documentation/Woobox/index.html#Introduction) [**Basic Installation**](https://iqonic.design/documentation/Woobox/index.html#installation-section) [Android Studio Setup Process](https://iqonic.design/documentation/Woobox/index.html#Setup-section) [**Android App Configuration**](https://iqonic.design/documentation/Woobox/index.html#AppConfiguration) [Open project in Android studio](https://iqonic.design/documentation/Woobox/index.html#Configuration1) [Change ApplicationID](https://iqonic.design/documentation/Woobox/index.html#Configuration2) [Change Application menu icon, background and app icon](https://iqonic.design/documentation/Woobox/index.html#Configuration3) [Change Application name](https://iqonic.design/documentation/Woobox/index.html#Configuration4) [Change app Font](https://iqonic.design/documentation/Woobox/index.html#Configuration5) [Change color](https://iqonic.design/documentation/Woobox/index.html#Configuration6) [Change Admob ID](https://iqonic.design/documentation/Woobox/index.html#Configuration7) [Change server URL](https://iqonic.design/documentation/Woobox/index.html#Configuration8) [Change Token](https://iqonic.design/documentation/Woobox/index.html#Configuration9) [Change Dashboard](https://iqonic.design/documentation/Woobox/index.html#Configuration10) [**Push Notification**](https://iqonic.design/documentation/Woobox/index.html#PushNotification) [Create a Firebase Project](https://iqonic.design/documentation/Woobox/index.html#CreateFirebaseProject) [Configure Firebase on App](https://iqonic.design/documentation/Woobox/index.html#ConfigureFirebaseApp) [Create New Account on OneSignal](https://iqonic.design/documentation/Woobox/index.html#ConfigurationOneSignal) [Configure OneSignal on App](https://iqonic.design/documentation/Woobox/index.html#AppOneSignalConfiguration) [Send Push Notification](https://iqonic.design/documentation/Woobox/index.html#SendPushNotification) [**Support & Assistance**](https://iqonic.design/documentation/Woobox/index.html#SupportAssistance) [**Refund Policy**](https://iqonic.design/documentation/Woobox/index.html#RefundPolicy) [**Greetings from Iqonic Design**](https://iqonic.design/documentation/Woobox/index.html#Greetings)

Developed by [Iqonic Design](https://themes.3rdwavemedia.com/) Designed by [Xiaoying Riley](https://themes.3rdwavemedia.com/)

Free VPN

Enjoyed our app? Give us 5 stars!

[Rate VPN](https://chrome.google.com/webstore/detail/free-vpn-the-fastest-vpn/enaobbodnmbpecahhojidoiblhmnohef/reviews)
