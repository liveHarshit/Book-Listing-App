package com.example.liveharshit.booklistingapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.renderscript.Sampler;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class QueryUtils {

    private QueryUtils () {

    }


    private static final String SAMPLE_JSON_RESPONSE = "{\n" +
            " \"kind\": \"books#volumes\",\n" +
            " \"totalItems\": 1788,\n" +
            " \"items\": [\n" +
            "  {\n" +
            "   \"kind\": \"books#volume\",\n" +
            "   \"id\": \"qKFDDAAAQBAJ\",\n" +
            "   \"etag\": \"yz/vB6rOU9Y\",\n" +
            "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/qKFDDAAAQBAJ\",\n" +
            "   \"volumeInfo\": {\n" +
            "    \"title\": \"Android\",\n" +
            "    \"authors\": [\n" +
            "     \"P.K. Dixit\"\n" +
            "    ],\n" +
            "    \"publisher\": \"Vikas Publishing House\",\n" +
            "    \"publishedDate\": \"2014\",\n" +
            "    \"description\": \"Android is a movement that has transferred data from laptop to hand-held devices like mobiles. Though there are alternate technologies that compete with Android, but it is the front runner in mobile technology by a long distance. Good knowledge in basic Java will help you to understand and develop Android technology and apps. Many universities in India and across the world are now teaching Android in their syllabus, which shows the importance of this subject. This book can be read by anyone who knows Java and XML concepts. It includes a lot of diagrams along with explanations to facilitate better understanding by students. This book aptly concludes with a project that uses Android, which will greatly benefit students in learning the practical aspects of Android. Key Features • Instructions in designing different Android user interfaces • Thorough explanations of all activities • JSON • Android-based project to aid practical understanding\",\n" +
            "    \"industryIdentifiers\": [\n" +
            "     {\n" +
            "      \"type\": \"ISBN_13\",\n" +
            "      \"identifier\": \"9789325977884\"\n" +
            "     },\n" +
            "     {\n" +
            "      \"type\": \"ISBN_10\",\n" +
            "      \"identifier\": \"9325977885\"\n" +
            "     }\n" +
            "    ],\n" +
            "    \"readingModes\": {\n" +
            "     \"text\": false,\n" +
            "     \"image\": true\n" +
            "    },\n" +
            "    \"pageCount\": 372,\n" +
            "    \"printType\": \"BOOK\",\n" +
            "    \"categories\": [\n" +
            "     \"Computers\"\n" +
            "    ],\n" +
            "    \"maturityRating\": \"NOT_MATURE\",\n" +
            "    \"allowAnonLogging\": false,\n" +
            "    \"contentVersion\": \"preview-1.0.0\",\n" +
            "    \"panelizationSummary\": {\n" +
            "     \"containsEpubBubbles\": false,\n" +
            "     \"containsImageBubbles\": false\n" +
            "    },\n" +
            "    \"imageLinks\": {\n" +
            "     \"smallThumbnail\": \"http://books.google.com/books/content?id=qKFDDAAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "     \"thumbnail\": \"http://books.google.com/books/content?id=qKFDDAAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "    },\n" +
            "    \"language\": \"en\",\n" +
            "    \"previewLink\": \"http://books.google.co.in/books?id=qKFDDAAAQBAJ&printsec=frontcover&dq=android&hl=&cd=1&source=gbs_api\",\n" +
            "    \"infoLink\": \"https://play.google.com/store/books/details?id=qKFDDAAAQBAJ&source=gbs_api\",\n" +
            "    \"canonicalVolumeLink\": \"https://market.android.com/details?id=book-qKFDDAAAQBAJ\"\n" +
            "   },\n" +
            "   \"saleInfo\": {\n" +
            "    \"country\": \"IN\",\n" +
            "    \"saleability\": \"FOR_SALE\",\n" +
            "    \"isEbook\": true,\n" +
            "    \"listPrice\": {\n" +
            "     \"amount\": 413.0,\n" +
            "     \"currencyCode\": \"INR\"\n" +
            "    },\n" +
            "    \"retailPrice\": {\n" +
            "     \"amount\": 289.1,\n" +
            "     \"currencyCode\": \"INR\"\n" +
            "    },\n" +
            "    \"buyLink\": \"https://play.google.com/store/books/details?id=qKFDDAAAQBAJ&rdid=book-qKFDDAAAQBAJ&rdot=1&source=gbs_api\",\n" +
            "    \"offers\": [\n" +
            "     {\n" +
            "      \"finskyOfferType\": 1,\n" +
            "      \"listPrice\": {\n" +
            "       \"amountInMicros\": 4.13E8,\n" +
            "       \"currencyCode\": \"INR\"\n" +
            "      },\n" +
            "      \"retailPrice\": {\n" +
            "       \"amountInMicros\": 2.891E8,\n" +
            "       \"currencyCode\": \"INR\"\n" +
            "      }\n" +
            "     }\n" +
            "    ]\n" +
            "   },\n" +
            "   \"accessInfo\": {\n" +
            "    \"country\": \"IN\",\n" +
            "    \"viewability\": \"PARTIAL\",\n" +
            "    \"embeddable\": true,\n" +
            "    \"publicDomain\": false,\n" +
            "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "    \"epub\": {\n" +
            "     \"isAvailable\": false\n" +
            "    },\n" +
            "    \"pdf\": {\n" +
            "     \"isAvailable\": true,\n" +
            "     \"acsTokenLink\": \"http://books.google.co.in/books/download/Android-sample-pdf.acsm?id=qKFDDAAAQBAJ&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "    },\n" +
            "    \"webReaderLink\": \"http://play.google.com/books/reader?id=qKFDDAAAQBAJ&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "    \"accessViewStatus\": \"SAMPLE\",\n" +
            "    \"quoteSharingAllowed\": false\n" +
            "   },\n" +
            "   \"searchInfo\": {\n" +
            "    \"textSnippet\": \"Many universities in India and across the world are now teaching Android in their syllabus, which shows the importance of this subject. This book can be read by anyone who knows Java and XML concepts.\"\n" +
            "   }\n" +
            "  },\n" +
            "  {\n" +
            "   \"kind\": \"books#volume\",\n" +
            "   \"id\": \"LY1FDwAAQBAJ\",\n" +
            "   \"etag\": \"P9nLVYCgtks\",\n" +
            "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/LY1FDwAAQBAJ\",\n" +
            "   \"volumeInfo\": {\n" +
            "    \"title\": \"Android Phones & Tablets For Dummies\",\n" +
            "    \"authors\": [\n" +
            "     \"Dan Gookin\"\n" +
            "    ],\n" +
            "    \"publisher\": \"John Wiley & Sons\",\n" +
            "    \"publishedDate\": \"2017-12-26\",\n" +
            "    \"description\": \"Outsmart your new Android Getting a smartphone or tablet can be intimidating for anyone, but this user-friendly guide is here to help you to get the most out of all your new gadget has to offer! Whether you’re upgrading from an older model or totally new to the awesome world of Androids, this book makes it easier than ever to get up and running with the latest technology. From setup and configuration to taking advantage of all those intricate bells and whistles, Android Phones & Tablets For Dummies helps you unleash everything your Android can do for you. If you’re looking to use your phone or tablet for texting, emailing, accessing the Internet, or anything in between, you’ll want to keep this go-to reference close by every step of the way. • Make sense of the phone features • Find your way around with navigation • Capture moments on the camera • Seamlessly sync with a PC or Mac Who needs a headache when dealing with a new device? This book makes it totally pain free!\",\n" +
            "    \"industryIdentifiers\": [\n" +
            "     {\n" +
            "      \"type\": \"ISBN_13\",\n" +
            "      \"identifier\": \"9781119453857\"\n" +
            "     },\n" +
            "     {\n" +
            "      \"type\": \"ISBN_10\",\n" +
            "      \"identifier\": \"1119453852\"\n" +
            "     }\n" +
            "    ],\n" +
            "    \"readingModes\": {\n" +
            "     \"text\": false,\n" +
            "     \"image\": true\n" +
            "    },\n" +
            "    \"pageCount\": 384,\n" +
            "    \"printType\": \"BOOK\",\n" +
            "    \"categories\": [\n" +
            "     \"Computers\"\n" +
            "    ],\n" +
            "    \"maturityRating\": \"NOT_MATURE\",\n" +
            "    \"allowAnonLogging\": false,\n" +
            "    \"contentVersion\": \"0.1.0.0.preview.1\",\n" +
            "    \"panelizationSummary\": {\n" +
            "     \"containsEpubBubbles\": false,\n" +
            "     \"containsImageBubbles\": false\n" +
            "    },\n" +
            "    \"imageLinks\": {\n" +
            "     \"smallThumbnail\": \"http://books.google.com/books/content?id=LY1FDwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "     \"thumbnail\": \"http://books.google.com/books/content?id=LY1FDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "    },\n" +
            "    \"language\": \"en\",\n" +
            "    \"previewLink\": \"http://books.google.co.in/books?id=LY1FDwAAQBAJ&printsec=frontcover&dq=android&hl=&cd=2&source=gbs_api\",\n" +
            "    \"infoLink\": \"http://books.google.co.in/books?id=LY1FDwAAQBAJ&dq=android&hl=&source=gbs_api\",\n" +
            "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/Android_Phones_Tablets_For_Dummies.html?hl=&id=LY1FDwAAQBAJ\"\n" +
            "   },\n" +
            "   \"saleInfo\": {\n" +
            "    \"country\": \"IN\",\n" +
            "    \"saleability\": \"NOT_FOR_SALE\",\n" +
            "    \"isEbook\": false\n" +
            "   },\n" +
            "   \"accessInfo\": {\n" +
            "    \"country\": \"IN\",\n" +
            "    \"viewability\": \"PARTIAL\",\n" +
            "    \"embeddable\": true,\n" +
            "    \"publicDomain\": false,\n" +
            "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "    \"epub\": {\n" +
            "     \"isAvailable\": false\n" +
            "    },\n" +
            "    \"pdf\": {\n" +
            "     \"isAvailable\": false\n" +
            "    },\n" +
            "    \"webReaderLink\": \"http://play.google.com/books/reader?id=LY1FDwAAQBAJ&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "    \"accessViewStatus\": \"SAMPLE\",\n" +
            "    \"quoteSharingAllowed\": false\n" +
            "   },\n" +
            "   \"searchInfo\": {\n" +
            "    \"textSnippet\": \"This book focuses on Android technology for both phones and tablets.\"\n" +
            "   }\n" +
            "  },\n" +
            "  {\n" +
            "   \"kind\": \"books#volume\",\n" +
            "   \"id\": \"KER0dd2oYP8C\",\n" +
            "   \"etag\": \"aLfT1SvQOi4\",\n" +
            "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/KER0dd2oYP8C\",\n" +
            "   \"volumeInfo\": {\n" +
            "    \"title\": \"Embedded Android\",\n" +
            "    \"subtitle\": \"Porting, Extending, and Customizing\",\n" +
            "    \"authors\": [\n" +
            "     \"Karim Yaghmour\"\n" +
            "    ],\n" +
            "    \"publisher\": \"\\\"O'Reilly Media, Inc.\\\"\",\n" +
            "    \"publishedDate\": \"2013-03-15\",\n" +
            "    \"description\": \"Embedded Android is for Developers wanting to create embedded systems based on Android and for those wanting to port Android to new hardware, or creating a custom development environment. Hackers and moders will also find this an indispensible guide to how Android works.\",\n" +
            "    \"industryIdentifiers\": [\n" +
            "     {\n" +
            "      \"type\": \"ISBN_13\",\n" +
            "      \"identifier\": \"9781449308292\"\n" +
            "     },\n" +
            "     {\n" +
            "      \"type\": \"ISBN_10\",\n" +
            "      \"identifier\": \"1449308295\"\n" +
            "     }\n" +
            "    ],\n" +
            "    \"readingModes\": {\n" +
            "     \"text\": false,\n" +
            "     \"image\": true\n" +
            "    },\n" +
            "    \"pageCount\": 385,\n" +
            "    \"printType\": \"BOOK\",\n" +
            "    \"categories\": [\n" +
            "     \"Computers\"\n" +
            "    ],\n" +
            "    \"averageRating\": 5.0,\n" +
            "    \"ratingsCount\": 2,\n" +
            "    \"maturityRating\": \"NOT_MATURE\",\n" +
            "    \"allowAnonLogging\": false,\n" +
            "    \"contentVersion\": \"preview-1.0.0\",\n" +
            "    \"imageLinks\": {\n" +
            "     \"smallThumbnail\": \"http://books.google.com/books/content?id=KER0dd2oYP8C&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "     \"thumbnail\": \"http://books.google.com/books/content?id=KER0dd2oYP8C&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "    },\n" +
            "    \"language\": \"en\",\n" +
            "    \"previewLink\": \"http://books.google.co.in/books?id=KER0dd2oYP8C&printsec=frontcover&dq=android&hl=&cd=3&source=gbs_api\",\n" +
            "    \"infoLink\": \"http://books.google.co.in/books?id=KER0dd2oYP8C&dq=android&hl=&source=gbs_api\",\n" +
            "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/Embedded_Android.html?hl=&id=KER0dd2oYP8C\"\n" +
            "   },\n" +
            "   \"saleInfo\": {\n" +
            "    \"country\": \"IN\",\n" +
            "    \"saleability\": \"NOT_FOR_SALE\",\n" +
            "    \"isEbook\": false\n" +
            "   },\n" +
            "   \"accessInfo\": {\n" +
            "    \"country\": \"IN\",\n" +
            "    \"viewability\": \"PARTIAL\",\n" +
            "    \"embeddable\": true,\n" +
            "    \"publicDomain\": false,\n" +
            "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "    \"epub\": {\n" +
            "     \"isAvailable\": false\n" +
            "    },\n" +
            "    \"pdf\": {\n" +
            "     \"isAvailable\": false\n" +
            "    },\n" +
            "    \"webReaderLink\": \"http://play.google.com/books/reader?id=KER0dd2oYP8C&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "    \"accessViewStatus\": \"SAMPLE\",\n" +
            "    \"quoteSharingAllowed\": false\n" +
            "   },\n" +
            "   \"searchInfo\": {\n" +
            "    \"textSnippet\": \"Hackers and moders will also find this an indispensible guide to how Android works.\"\n" +
            "   }\n" +
            "  },\n" +
            "  {\n" +
            "   \"kind\": \"books#volume\",\n" +
            "   \"id\": \"MoXpe6H2B5gC\",\n" +
            "   \"etag\": \"EprOG9TrPEw\",\n" +
            "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/MoXpe6H2B5gC\",\n" +
            "   \"volumeInfo\": {\n" +
            "    \"title\": \"Android in The Attic\",\n" +
            "    \"authors\": [\n" +
            "     \"Nicholas Allan\"\n" +
            "    ],\n" +
            "    \"publisher\": \"Hachette UK\",\n" +
            "    \"publishedDate\": \"2013-01-03\",\n" +
            "    \"description\": \"Aunt Edna has created a no-nonsense nanny android to make sure Billy and Alfie don't have any fun. But then Alfie discovers how to override Auntie Anne-Droid's programming and nothing can stop them eating all the Cheeki Choko Cherry Cakes they like ... until the real aunt Edna is kidnapped!\",\n" +
            "    \"industryIdentifiers\": [\n" +
            "     {\n" +
            "      \"type\": \"ISBN_13\",\n" +
            "      \"identifier\": \"9781444905465\"\n" +
            "     },\n" +
            "     {\n" +
            "      \"type\": \"ISBN_10\",\n" +
            "      \"identifier\": \"1444905465\"\n" +
            "     }\n" +
            "    ],\n" +
            "    \"readingModes\": {\n" +
            "     \"text\": true,\n" +
            "     \"image\": false\n" +
            "    },\n" +
            "    \"pageCount\": 192,\n" +
            "    \"printType\": \"BOOK\",\n" +
            "    \"categories\": [\n" +
            "     \"Juvenile Fiction\"\n" +
            "    ],\n" +
            "    \"maturityRating\": \"NOT_MATURE\",\n" +
            "    \"allowAnonLogging\": false,\n" +
            "    \"contentVersion\": \"1.2.2.0.preview.2\",\n" +
            "    \"panelizationSummary\": {\n" +
            "     \"containsEpubBubbles\": false,\n" +
            "     \"containsImageBubbles\": false\n" +
            "    },\n" +
            "    \"imageLinks\": {\n" +
            "     \"smallThumbnail\": \"http://books.google.com/books/content?id=MoXpe6H2B5gC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "     \"thumbnail\": \"http://books.google.com/books/content?id=MoXpe6H2B5gC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "    },\n" +
            "    \"language\": \"en\",\n" +
            "    \"previewLink\": \"http://books.google.co.in/books?id=MoXpe6H2B5gC&printsec=frontcover&dq=android&hl=&cd=4&source=gbs_api\",\n" +
            "    \"infoLink\": \"https://play.google.com/store/books/details?id=MoXpe6H2B5gC&source=gbs_api\",\n" +
            "    \"canonicalVolumeLink\": \"https://market.android.com/details?id=book-MoXpe6H2B5gC\"\n" +
            "   },\n" +
            "   \"saleInfo\": {\n" +
            "    \"country\": \"IN\",\n" +
            "    \"saleability\": \"FOR_SALE\",\n" +
            "    \"isEbook\": true,\n" +
            "    \"listPrice\": {\n" +
            "     \"amount\": 250.16,\n" +
            "     \"currencyCode\": \"INR\"\n" +
            "    },\n" +
            "    \"retailPrice\": {\n" +
            "     \"amount\": 175.11,\n" +
            "     \"currencyCode\": \"INR\"\n" +
            "    },\n" +
            "    \"buyLink\": \"https://play.google.com/store/books/details?id=MoXpe6H2B5gC&rdid=book-MoXpe6H2B5gC&rdot=1&source=gbs_api\",\n" +
            "    \"offers\": [\n" +
            "     {\n" +
            "      \"finskyOfferType\": 1,\n" +
            "      \"listPrice\": {\n" +
            "       \"amountInMicros\": 2.5016E8,\n" +
            "       \"currencyCode\": \"INR\"\n" +
            "      },\n" +
            "      \"retailPrice\": {\n" +
            "       \"amountInMicros\": 1.7511E8,\n" +
            "       \"currencyCode\": \"INR\"\n" +
            "      }\n" +
            "     }\n" +
            "    ]\n" +
            "   },\n" +
            "   \"accessInfo\": {\n" +
            "    \"country\": \"IN\",\n" +
            "    \"viewability\": \"PARTIAL\",\n" +
            "    \"embeddable\": true,\n" +
            "    \"publicDomain\": false,\n" +
            "    \"textToSpeechPermission\": \"ALLOWED_FOR_ACCESSIBILITY\",\n" +
            "    \"epub\": {\n" +
            "     \"isAvailable\": true,\n" +
            "     \"acsTokenLink\": \"http://books.google.co.in/books/download/Android_in_The_Attic-sample-epub.acsm?id=MoXpe6H2B5gC&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "    },\n" +
            "    \"pdf\": {\n" +
            "     \"isAvailable\": false\n" +
            "    },\n" +
            "    \"webReaderLink\": \"http://play.google.com/books/reader?id=MoXpe6H2B5gC&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "    \"accessViewStatus\": \"SAMPLE\",\n" +
            "    \"quoteSharingAllowed\": false\n" +
            "   },\n" +
            "   \"searchInfo\": {\n" +
            "    \"textSnippet\": \"Aunt Edna has created a no-nonsense nanny android to make sure Billy and Alfie don&#39;t have any fun.\"\n" +
            "   }\n" +
            "  },\n" +
            "  {\n" +
            "   \"kind\": \"books#volume\",\n" +
            "   \"id\": \"TwV45aVC14IC\",\n" +
            "   \"etag\": \"4ZQlUyYJpZc\",\n" +
            "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/TwV45aVC14IC\",\n" +
            "   \"volumeInfo\": {\n" +
            "    \"title\": \"Android Programming Unleashed\",\n" +
            "    \"authors\": [\n" +
            "     \"B.M. Harwani\"\n" +
            "    ],\n" +
            "    \"publisher\": \"Sams Publishing\",\n" +
            "    \"publishedDate\": \"2012-12-14\",\n" +
            "    \"description\": \"Android Programming Unleashed is the most comprehensive and technically sophisticated guide to best-practice Android development with today's powerful new versions of Android: 4.1 (Jelly Bean) and 4.0.3 (Ice Cream Sandwich). Offering the exceptional breadth and depth developers have come to expect from the Unleashed series, it covers everything programmers need to know to develop robust, high-performance Android apps that deliver a superior user experience. Leading developer trainer Bintu Harwani begins with basic UI controls, then progresses to more advanced topics, finally covering how to develop feature rich Android applications that can access Internet-based services and store data. He illuminates each important SDK component through complete, self-contained code examples that show developers the most effective ways to build production-ready code. Coverage includes: understanding the modern Android platform from the developer's standpoint… using widgets, containers, resources, selection widgets, dialogs, and fragments… supporting actions and persistence… incorporating menus, ActionBars, content providers, and databases… integrating media and animations… using web, map, and other services… supporting communication via messaging, contacts, and emails… publishing Android apps, and much more.\",\n" +
            "    \"industryIdentifiers\": [\n" +
            "     {\n" +
            "      \"type\": \"ISBN_13\",\n" +
            "      \"identifier\": \"9780133151749\"\n" +
            "     },\n" +
            "     {\n" +
            "      \"type\": \"ISBN_10\",\n" +
            "      \"identifier\": \"0133151743\"\n" +
            "     }\n" +
            "    ],\n" +
            "    \"readingModes\": {\n" +
            "     \"text\": true,\n" +
            "     \"image\": true\n" +
            "    },\n" +
            "    \"pageCount\": 696,\n" +
            "    \"printType\": \"BOOK\",\n" +
            "    \"categories\": [\n" +
            "     \"Computers\"\n" +
            "    ],\n" +
            "    \"maturityRating\": \"NOT_MATURE\",\n" +
            "    \"allowAnonLogging\": true,\n" +
            "    \"contentVersion\": \"1.5.5.0.preview.3\",\n" +
            "    \"panelizationSummary\": {\n" +
            "     \"containsEpubBubbles\": false,\n" +
            "     \"containsImageBubbles\": false\n" +
            "    },\n" +
            "    \"imageLinks\": {\n" +
            "     \"smallThumbnail\": \"http://books.google.com/books/content?id=TwV45aVC14IC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "     \"thumbnail\": \"http://books.google.com/books/content?id=TwV45aVC14IC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "    },\n" +
            "    \"language\": \"en\",\n" +
            "    \"previewLink\": \"http://books.google.co.in/books?id=TwV45aVC14IC&printsec=frontcover&dq=android&hl=&cd=5&source=gbs_api\",\n" +
            "    \"infoLink\": \"https://play.google.com/store/books/details?id=TwV45aVC14IC&source=gbs_api\",\n" +
            "    \"canonicalVolumeLink\": \"https://market.android.com/details?id=book-TwV45aVC14IC\"\n" +
            "   },\n" +
            "   \"saleInfo\": {\n" +
            "    \"country\": \"IN\",\n" +
            "    \"saleability\": \"FOR_SALE\",\n" +
            "    \"isEbook\": true,\n" +
            "    \"listPrice\": {\n" +
            "     \"amount\": 2018.55,\n" +
            "     \"currencyCode\": \"INR\"\n" +
            "    },\n" +
            "    \"retailPrice\": {\n" +
            "     \"amount\": 2018.55,\n" +
            "     \"currencyCode\": \"INR\"\n" +
            "    },\n" +
            "    \"buyLink\": \"https://play.google.com/store/books/details?id=TwV45aVC14IC&rdid=book-TwV45aVC14IC&rdot=1&source=gbs_api\",\n" +
            "    \"offers\": [\n" +
            "     {\n" +
            "      \"finskyOfferType\": 1,\n" +
            "      \"listPrice\": {\n" +
            "       \"amountInMicros\": 2.01855E9,\n" +
            "       \"currencyCode\": \"INR\"\n" +
            "      },\n" +
            "      \"retailPrice\": {\n" +
            "       \"amountInMicros\": 2.01855E9,\n" +
            "       \"currencyCode\": \"INR\"\n" +
            "      }\n" +
            "     }\n" +
            "    ]\n" +
            "   },\n" +
            "   \"accessInfo\": {\n" +
            "    \"country\": \"IN\",\n" +
            "    \"viewability\": \"PARTIAL\",\n" +
            "    \"embeddable\": true,\n" +
            "    \"publicDomain\": false,\n" +
            "    \"textToSpeechPermission\": \"ALLOWED_FOR_ACCESSIBILITY\",\n" +
            "    \"epub\": {\n" +
            "     \"isAvailable\": false\n" +
            "    },\n" +
            "    \"pdf\": {\n" +
            "     \"isAvailable\": false\n" +
            "    },\n" +
            "    \"webReaderLink\": \"http://play.google.com/books/reader?id=TwV45aVC14IC&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "    \"accessViewStatus\": \"SAMPLE\",\n" +
            "    \"quoteSharingAllowed\": false\n" +
            "   },\n" +
            "   \"searchInfo\": {\n" +
            "    \"textSnippet\": \"Offering the exceptional breadth and depth developers have come to expect from the Unleashed series, it covers everything programmers need to know to develop robust, high-performance Android apps that deliver a superior user experience.\"\n" +
            "   }\n" +
            "  },\n" +
            "  {\n" +
            "   \"kind\": \"books#volume\",\n" +
            "   \"id\": \"2XeNswkT_2YC\",\n" +
            "   \"etag\": \"p8SYjvM9CiI\",\n" +
            "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/2XeNswkT_2YC\",\n" +
            "   \"volumeInfo\": {\n" +
            "    \"title\": \"Beginning Android 2\",\n" +
            "    \"authors\": [\n" +
            "     \"Mark Murphy\"\n" +
            "    ],\n" +
            "    \"publisher\": \"Apress\",\n" +
            "    \"publishedDate\": \"2010-03-19\",\n" +
            "    \"description\": \"The Android development platform, created by Google and the Open Handset Alliance, is a platform in its truest sense, encompassing hundreds of classes beyond the traditional Java classes and open source components that ship with the SDK. With Beginning Android 2, you’ll learn how to develop applications for Android 2.x mobile devices, using simple examples that are ready to run with your copy of the software development kit. Author, Android columnist, writer, developer, and community advocate Mark L. Murphy will show you what you need to know to get started programming Android applications, including how to craft graphical user interfaces, use GPS, and access web services. What you’ll learn Discover Android and how to use it to build Java-based mobile applications for a wide range of phones and other devices. Create user interfaces using both the Android widget framework and the built-in WebKit-powered Web browser components. Utilize the distinctive capabilities of the Android engine, including location tracking, maps, and Internet access. Use and create Android applications incorporating activities, services, content providers, and broadcast receivers. Support Android 1.5, 1.6, and 2.0 devices, including dealing with multiple Android OS versions, multiple screen sizes, and other device-specific characteristics. Who this book is for This book is aimed at people new to mobile development, but with some knowledge of Java. Table of Contents The Big Picture Projects & Targets Creating a Skeleton Application Using XML-Based Layouts Employing Basic Widgets Working with Containers Using Selection Widgets Getting Fancy With Lists Employing Fancy Widgets and Containers The Input Method Framework Applying Menus Fonts Embedding the WebKit Browser Showing Pop-Up Messages Dealing with Threads Handling Activity Lifecycle Events Creating Intent Filters Launching Activities and Sub-Activities Handling Rotation Working with Resources Using Preferences Managing and Accessing Local Databases Accessing Files Leveraging Java Libraries Communicating via the Internet Using a Content Provider Building a Content Provider Requesting and Requiring Permissions Creating a Service Invoking a Service Alerting Users Via Notifications Accessing Location-Based Services Mapping with MapView and MapActivity Handling Telephone Calls Development Tools Handling Multiple Screen Sizes Dealing with Devices Handling Platform Changes Where Do We Go From Here?\",\n" +
            "    \"industryIdentifiers\": [\n" +
            "     {\n" +
            "      \"type\": \"ISBN_13\",\n" +
            "      \"identifier\": \"9781430226291\"\n" +
            "     },\n" +
            "     {\n" +
            "      \"type\": \"ISBN_10\",\n" +
            "      \"identifier\": \"1430226293\"\n" +
            "     }\n" +
            "    ],\n" +
            "    \"readingModes\": {\n" +
            "     \"text\": true,\n" +
            "     \"image\": true\n" +
            "    },\n" +
            "    \"pageCount\": 416,\n" +
            "    \"printType\": \"BOOK\",\n" +
            "    \"categories\": [\n" +
            "     \"Computers\"\n" +
            "    ],\n" +
            "    \"averageRating\": 2.0,\n" +
            "    \"ratingsCount\": 2,\n" +
            "    \"maturityRating\": \"NOT_MATURE\",\n" +
            "    \"allowAnonLogging\": true,\n" +
            "    \"contentVersion\": \"1.3.3.0.preview.3\",\n" +
            "    \"panelizationSummary\": {\n" +
            "     \"containsEpubBubbles\": false,\n" +
            "     \"containsImageBubbles\": false\n" +
            "    },\n" +
            "    \"imageLinks\": {\n" +
            "     \"smallThumbnail\": \"http://books.google.com/books/content?id=2XeNswkT_2YC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "     \"thumbnail\": \"http://books.google.com/books/content?id=2XeNswkT_2YC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "    },\n" +
            "    \"language\": \"en\",\n" +
            "    \"previewLink\": \"http://books.google.co.in/books?id=2XeNswkT_2YC&pg=PA180&dq=android&hl=&cd=6&source=gbs_api\",\n" +
            "    \"infoLink\": \"http://books.google.co.in/books?id=2XeNswkT_2YC&dq=android&hl=&source=gbs_api\",\n" +
            "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/Beginning_Android_2.html?hl=&id=2XeNswkT_2YC\"\n" +
            "   },\n" +
            "   \"saleInfo\": {\n" +
            "    \"country\": \"IN\",\n" +
            "    \"saleability\": \"NOT_FOR_SALE\",\n" +
            "    \"isEbook\": false\n" +
            "   },\n" +
            "   \"accessInfo\": {\n" +
            "    \"country\": \"IN\",\n" +
            "    \"viewability\": \"PARTIAL\",\n" +
            "    \"embeddable\": true,\n" +
            "    \"publicDomain\": false,\n" +
            "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "    \"epub\": {\n" +
            "     \"isAvailable\": true,\n" +
            "     \"acsTokenLink\": \"http://books.google.co.in/books/download/Beginning_Android_2-sample-epub.acsm?id=2XeNswkT_2YC&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "    },\n" +
            "    \"pdf\": {\n" +
            "     \"isAvailable\": true,\n" +
            "     \"acsTokenLink\": \"http://books.google.co.in/books/download/Beginning_Android_2-sample-pdf.acsm?id=2XeNswkT_2YC&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "    },\n" +
            "    \"webReaderLink\": \"http://play.google.com/books/reader?id=2XeNswkT_2YC&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "    \"accessViewStatus\": \"SAMPLE\",\n" +
            "    \"quoteSharingAllowed\": false\n" +
            "   },\n" +
            "   \"searchInfo\": {\n" +
            "    \"textSnippet\": \"\\u003cb\\u003eandroid\\u003c/b\\u003e :layout_weight=&quot;l&quot; /&gt; &lt;EditText \\u003cb\\u003eandroid\\u003c/b\\u003e :id=&quot;@+id/lon&quot; \\u003cb\\u003eandroid\\u003c/b\\u003e : \\u003cbr\\u003e\\nlayout_width=&quot;f ill_parent &quot; \\u003cb\\u003eandroid\\u003c/b\\u003e : layout_height=&quot;wrap_content&quot; \\u003cb\\u003eandroid\\u003c/b\\u003e :\\u003cbr\\u003e\\ncursorVisible= &quot;true&quot; \\u003cb\\u003eandroid\\u003c/b\\u003e :editable=&quot;true&quot; \\u003cb\\u003eandroid\\u003c/b\\u003e : singlel_ine=&quot;true&quot; \\u003cb\\u003eandroid\\u003c/b\\u003e\\u003cbr\\u003e\\n&nbsp;...\"\n" +
            "   }\n" +
            "  },\n" +
            "  {\n" +
            "   \"kind\": \"books#volume\",\n" +
            "   \"id\": \"nbCbJe6vpZ0C\",\n" +
            "   \"etag\": \"YI2tGPBpnWI\",\n" +
            "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/nbCbJe6vpZ0C\",\n" +
            "   \"volumeInfo\": {\n" +
            "    \"title\": \"The Android Developer's Cookbook\",\n" +
            "    \"subtitle\": \"Building Applications with the Android SDK\",\n" +
            "    \"authors\": [\n" +
            "     \"Ronan Schwarz\",\n" +
            "     \"Phil Dutson\",\n" +
            "     \"James Steele\",\n" +
            "     \"Nelson To\"\n" +
            "    ],\n" +
            "    \"publisher\": \"Addison-Wesley\",\n" +
            "    \"publishedDate\": \"2013-07-02\",\n" +
            "    \"description\": \"Do you want to get started building apps for Android, today’s number one mobile platform? Are you already building Android apps but want to get better at it? The Android ™ Developer’s Cookbook, Second Edition, brings together all the expert guidance and code you’ll need. This edition has been extensively updated to reflect the other Android 4.2.2 releases. You’ll find all-new chapters on advanced threading and UI development, in-app billing, push messages, and native development, plus new techniques for everything from accessing NFC hardware to using Google Cloud Messaging. Proven modular recipes take you from the basics all the way to advanced services, helping you to make the most of the newest Android APIs and tools. The authors’ fully updated code samples are designed to serve as templates for your own projects and components. You’ll learn best-practice techniques for efficiently solving common problems and for avoiding pitfalls throughout the entire development lifecycle. Coverage includes Organizing Android apps and integrating their activities Working efficiently with services, receivers, and alerts Managing threads, including advanced techniques using AsyncTasks and loaders Building robust, intuitive user interfaces Implementing advanced UI features, including Custom Views, animation, accessibility, and large screen support Capturing, playing, and manipulating media Interacting with SMS, websites, and social networks Storing data via SQLite and other methods Integrating in-app billing using Google Play services Managing push messaging with C2DM Leveraging new components and structures for native Android development Efficiently testing and debugging with Android’s latest tools and techniques, including LINT code analysis The Android ™ Developer’s Cookbook, Second Edition, is all you need to jumpstart any Android project, and create high-value, feature-rich apps that sell.\",\n" +
            "    \"industryIdentifiers\": [\n" +
            "     {\n" +
            "      \"type\": \"ISBN_13\",\n" +
            "      \"identifier\": \"9780133261592\"\n" +
            "     },\n" +
            "     {\n" +
            "      \"type\": \"ISBN_10\",\n" +
            "      \"identifier\": \"013326159X\"\n" +
            "     }\n" +
            "    ],\n" +
            "    \"readingModes\": {\n" +
            "     \"text\": true,\n" +
            "     \"image\": true\n" +
            "    },\n" +
            "    \"pageCount\": 464,\n" +
            "    \"printType\": \"BOOK\",\n" +
            "    \"categories\": [\n" +
            "     \"Computers\"\n" +
            "    ],\n" +
            "    \"maturityRating\": \"NOT_MATURE\",\n" +
            "    \"allowAnonLogging\": true,\n" +
            "    \"contentVersion\": \"0.4.3.0.preview.3\",\n" +
            "    \"panelizationSummary\": {\n" +
            "     \"containsEpubBubbles\": false,\n" +
            "     \"containsImageBubbles\": false\n" +
            "    },\n" +
            "    \"imageLinks\": {\n" +
            "     \"smallThumbnail\": \"http://books.google.com/books/content?id=nbCbJe6vpZ0C&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "     \"thumbnail\": \"http://books.google.com/books/content?id=nbCbJe6vpZ0C&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "    },\n" +
            "    \"language\": \"en\",\n" +
            "    \"previewLink\": \"http://books.google.co.in/books?id=nbCbJe6vpZ0C&printsec=frontcover&dq=android&hl=&cd=7&source=gbs_api\",\n" +
            "    \"infoLink\": \"https://play.google.com/store/books/details?id=nbCbJe6vpZ0C&source=gbs_api\",\n" +
            "    \"canonicalVolumeLink\": \"https://market.android.com/details?id=book-nbCbJe6vpZ0C\"\n" +
            "   },\n" +
            "   \"saleInfo\": {\n" +
            "    \"country\": \"IN\",\n" +
            "    \"saleability\": \"FOR_SALE\",\n" +
            "    \"isEbook\": true,\n" +
            "    \"listPrice\": {\n" +
            "     \"amount\": 2070.59,\n" +
            "     \"currencyCode\": \"INR\"\n" +
            "    },\n" +
            "    \"retailPrice\": {\n" +
            "     \"amount\": 2070.59,\n" +
            "     \"currencyCode\": \"INR\"\n" +
            "    },\n" +
            "    \"buyLink\": \"https://play.google.com/store/books/details?id=nbCbJe6vpZ0C&rdid=book-nbCbJe6vpZ0C&rdot=1&source=gbs_api\",\n" +
            "    \"offers\": [\n" +
            "     {\n" +
            "      \"finskyOfferType\": 1,\n" +
            "      \"listPrice\": {\n" +
            "       \"amountInMicros\": 2.07059E9,\n" +
            "       \"currencyCode\": \"INR\"\n" +
            "      },\n" +
            "      \"retailPrice\": {\n" +
            "       \"amountInMicros\": 2.07059E9,\n" +
            "       \"currencyCode\": \"INR\"\n" +
            "      }\n" +
            "     }\n" +
            "    ]\n" +
            "   },\n" +
            "   \"accessInfo\": {\n" +
            "    \"country\": \"IN\",\n" +
            "    \"viewability\": \"PARTIAL\",\n" +
            "    \"embeddable\": true,\n" +
            "    \"publicDomain\": false,\n" +
            "    \"textToSpeechPermission\": \"ALLOWED_FOR_ACCESSIBILITY\",\n" +
            "    \"epub\": {\n" +
            "     \"isAvailable\": false\n" +
            "    },\n" +
            "    \"pdf\": {\n" +
            "     \"isAvailable\": false\n" +
            "    },\n" +
            "    \"webReaderLink\": \"http://play.google.com/books/reader?id=nbCbJe6vpZ0C&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "    \"accessViewStatus\": \"SAMPLE\",\n" +
            "    \"quoteSharingAllowed\": false\n" +
            "   },\n" +
            "   \"searchInfo\": {\n" +
            "    \"textSnippet\": \"The Android ™ Developer’s Cookbook, Second Edition, brings together all the expert guidance and code you’ll need. This edition has been extensively updated to reflect the other Android 4.2.2 releases.\"\n" +
            "   }\n" +
            "  },\n" +
            "  {\n" +
            "   \"kind\": \"books#volume\",\n" +
            "   \"id\": \"Bam8K5SIiTkC\",\n" +
            "   \"etag\": \"fYZVur5r8Ok\",\n" +
            "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/Bam8K5SIiTkC\",\n" +
            "   \"volumeInfo\": {\n" +
            "    \"title\": \"Pro Android 2\",\n" +
            "    \"authors\": [\n" +
            "     \"Sayed Hashimi\",\n" +
            "     \"Satya Komatineni\",\n" +
            "     \"Dave MacLean\"\n" +
            "    ],\n" +
            "    \"publisher\": \"Apress\",\n" +
            "    \"publishedDate\": \"2010-03-15\",\n" +
            "    \"description\": \"Pro Android 2 shows how to build real-world and fun mobile applications using Google’s latest Android software development kit. This new edition is updated for Android 2, covering everything from the fundamentals of building applications for embedded devices to advanced concepts such as custom 3D components, OpenGL, and touchscreens including gestures. While other Android development guides simply discuss topics, Pro Android 2 offers the combination of expert insight and real sample applications that work. Discover the design and architecture of the Android SDK through practical examples, and how to build mobile applications using the Android SDK. Explore and use the Android APIs, including those for media and Wi-Fi. Learn about Android 2’s integrated local and web search, handwriting gesture UI, Google Translate, and text-to-speech features. Pro Android 2 dives deep, providing you with all the knowledge and techniques you need to build mobile applications ranging from games to Google apps, including add-ons to Google Docs. You’ll be able to extend and run the new Google Chrome APIs on the G1, the G2, and other next-generation Google phones and Android-enabled devices. What you’ll learn How to use Android to build Java-based mobile applications for Google phones with a touch screen or keyboard (thanks to Cupcake’s inclusion as of Android 1.5) How to design and architect using Google’s latest Android SDK How to use the Android SDK to write mobile applications for embedded devices How to create 3D graphics with OpenGL and custom components How to build multimedia and game apps using Android’s Media APIs and OpenGL How to use Android’s location-based services, networking (Wi-Fi APIs), and security How to create and allow for more integrated local and web searches How to build handwriting gesture UIs How to incorporate Google Translate into your Android applications Who this book is for This book is for professional software engineers/programmers looking to move their ideas and applications into the mobile space with Android. It assumes that readers have a passable understanding of Java, including being able to write classes and handle basic inheritance structures. This book also targets hobbyists. Table of Contents Introducing the Android Computing Platform Getting Your Feet Wet Using Resources, Content Providers, and Intents Building User Interfaces and Using Controls Working with Menus and Dialogs Unveiling 2D Animation Exploring Security and Location-Based Services Building and Consuming Services Using the Media Framework and Telephony APIs Programming 3D Graphics with OpenGL Managing and Organizing Preferences Exploring Live Folders Home Screen Widgets Android Search Exploring Text to Speech and Translate APIs Touchscreens Titanium Mobile: A WebKit-Based Approach to Android Development Working with Android Market Outlook and Resources\",\n" +
            "    \"industryIdentifiers\": [\n" +
            "     {\n" +
            "      \"type\": \"ISBN_13\",\n" +
            "      \"identifier\": \"9781430226598\"\n" +
            "     },\n" +
            "     {\n" +
            "      \"type\": \"ISBN_10\",\n" +
            "      \"identifier\": \"1430226595\"\n" +
            "     }\n" +
            "    ],\n" +
            "    \"readingModes\": {\n" +
            "     \"text\": true,\n" +
            "     \"image\": true\n" +
            "    },\n" +
            "    \"pageCount\": 736,\n" +
            "    \"printType\": \"BOOK\",\n" +
            "    \"categories\": [\n" +
            "     \"Computers\"\n" +
            "    ],\n" +
            "    \"averageRating\": 2.5,\n" +
            "    \"ratingsCount\": 6,\n" +
            "    \"maturityRating\": \"NOT_MATURE\",\n" +
            "    \"allowAnonLogging\": true,\n" +
            "    \"contentVersion\": \"0.2.1.0.preview.3\",\n" +
            "    \"panelizationSummary\": {\n" +
            "     \"containsEpubBubbles\": false,\n" +
            "     \"containsImageBubbles\": false\n" +
            "    },\n" +
            "    \"imageLinks\": {\n" +
            "     \"smallThumbnail\": \"http://books.google.com/books/content?id=Bam8K5SIiTkC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "     \"thumbnail\": \"http://books.google.com/books/content?id=Bam8K5SIiTkC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "    },\n" +
            "    \"language\": \"en\",\n" +
            "    \"previewLink\": \"http://books.google.co.in/books?id=Bam8K5SIiTkC&pg=PA217&dq=android&hl=&cd=8&source=gbs_api\",\n" +
            "    \"infoLink\": \"http://books.google.co.in/books?id=Bam8K5SIiTkC&dq=android&hl=&source=gbs_api\",\n" +
            "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/Pro_Android_2.html?hl=&id=Bam8K5SIiTkC\"\n" +
            "   },\n" +
            "   \"saleInfo\": {\n" +
            "    \"country\": \"IN\",\n" +
            "    \"saleability\": \"NOT_FOR_SALE\",\n" +
            "    \"isEbook\": false\n" +
            "   },\n" +
            "   \"accessInfo\": {\n" +
            "    \"country\": \"IN\",\n" +
            "    \"viewability\": \"PARTIAL\",\n" +
            "    \"embeddable\": true,\n" +
            "    \"publicDomain\": false,\n" +
            "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "    \"epub\": {\n" +
            "     \"isAvailable\": true,\n" +
            "     \"acsTokenLink\": \"http://books.google.co.in/books/download/Pro_Android_2-sample-epub.acsm?id=Bam8K5SIiTkC&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "    },\n" +
            "    \"pdf\": {\n" +
            "     \"isAvailable\": true,\n" +
            "     \"acsTokenLink\": \"http://books.google.co.in/books/download/Pro_Android_2-sample-pdf.acsm?id=Bam8K5SIiTkC&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "    },\n" +
            "    \"webReaderLink\": \"http://play.google.com/books/reader?id=Bam8K5SIiTkC&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "    \"accessViewStatus\": \"SAMPLE\",\n" +
            "    \"quoteSharingAllowed\": false\n" +
            "   },\n" +
            "   \"searchInfo\": {\n" +
            "    \"textSnippet\": \"The previous chapters gave you a broad introduction to UI programming in \\u003cbr\\u003e\\n\\u003cb\\u003eAndroid\\u003c/b\\u003e. In this chapter, we would like to further strengthen your ability to create \\u003cbr\\u003e\\nintuitive and appealing applications on the \\u003cb\\u003eAndroid\\u003c/b\\u003e Platform by covering the \\u003cbr\\u003e\\nanimation&nbsp;...\"\n" +
            "   }\n" +
            "  },\n" +
            "  {\n" +
            "   \"kind\": \"books#volume\",\n" +
            "   \"id\": \"zWndz5OpUzgC\",\n" +
            "   \"etag\": \"9Un1QgjXCmE\",\n" +
            "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/zWndz5OpUzgC\",\n" +
            "   \"volumeInfo\": {\n" +
            "    \"title\": \"Building Android Apps with HTML, CSS, and JavaScript\",\n" +
            "    \"subtitle\": \"Making Native Apps with Standards-Based Web Tools\",\n" +
            "    \"authors\": [\n" +
            "     \"Jonathan Stark\",\n" +
            "     \"Brian Jepson\",\n" +
            "     \"Brian MacDonald\"\n" +
            "    ],\n" +
            "    \"publisher\": \"\\\"O'Reilly Media, Inc.\\\"\",\n" +
            "    \"publishedDate\": \"2012-01-13\",\n" +
            "    \"description\": \"If you know HTML, CSS, and JavaScript, you already have the tools you need to develop Android applications. Now updated for HTML5, the second edition of this hands-on guide shows you how to use open source web standards to design and build apps that can be adapted for any Android device. You’ll learn how to create an Android-friendly web app on the platform of your choice, and then use Adobe’s free PhoneGap framework to convert it to a native Android app. Discover why device-agnostic mobile apps are the wave of the future, and start building apps that offer greater flexibility and a much broader reach. Convert a website into a web application, complete with progress indicators and other features Add animation with JQTouch to make your web app look and feel like a native Android app Make use of client-side data storage with apps that run when the Android device is offline Use PhoneGap to hook into advanced Android features, including the accelerometer, geolocation, and alerts Test and debug your app on the Web with real users, and submit the finished product to the Android Market\",\n" +
            "    \"industryIdentifiers\": [\n" +
            "     {\n" +
            "      \"type\": \"ISBN_13\",\n" +
            "      \"identifier\": \"9781449327934\"\n" +
            "     },\n" +
            "     {\n" +
            "      \"type\": \"ISBN_10\",\n" +
            "      \"identifier\": \"1449327931\"\n" +
            "     }\n" +
            "    ],\n" +
            "    \"readingModes\": {\n" +
            "     \"text\": true,\n" +
            "     \"image\": true\n" +
            "    },\n" +
            "    \"pageCount\": 178,\n" +
            "    \"printType\": \"BOOK\",\n" +
            "    \"categories\": [\n" +
            "     \"Computers\"\n" +
            "    ],\n" +
            "    \"maturityRating\": \"NOT_MATURE\",\n" +
            "    \"allowAnonLogging\": true,\n" +
            "    \"contentVersion\": \"2.2.2.0.preview.3\",\n" +
            "    \"panelizationSummary\": {\n" +
            "     \"containsEpubBubbles\": false,\n" +
            "     \"containsImageBubbles\": false\n" +
            "    },\n" +
            "    \"imageLinks\": {\n" +
            "     \"smallThumbnail\": \"http://books.google.com/books/content?id=zWndz5OpUzgC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "     \"thumbnail\": \"http://books.google.com/books/content?id=zWndz5OpUzgC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "    },\n" +
            "    \"language\": \"en\",\n" +
            "    \"previewLink\": \"http://books.google.co.in/books?id=zWndz5OpUzgC&printsec=frontcover&dq=android&hl=&cd=9&source=gbs_api\",\n" +
            "    \"infoLink\": \"https://play.google.com/store/books/details?id=zWndz5OpUzgC&source=gbs_api\",\n" +
            "    \"canonicalVolumeLink\": \"https://market.android.com/details?id=book-zWndz5OpUzgC\"\n" +
            "   },\n" +
            "   \"saleInfo\": {\n" +
            "    \"country\": \"IN\",\n" +
            "    \"saleability\": \"FOR_SALE\",\n" +
            "    \"isEbook\": true,\n" +
            "    \"listPrice\": {\n" +
            "     \"amount\": 1770.0,\n" +
            "     \"currencyCode\": \"INR\"\n" +
            "    },\n" +
            "    \"retailPrice\": {\n" +
            "     \"amount\": 1770.0,\n" +
            "     \"currencyCode\": \"INR\"\n" +
            "    },\n" +
            "    \"buyLink\": \"https://play.google.com/store/books/details?id=zWndz5OpUzgC&rdid=book-zWndz5OpUzgC&rdot=1&source=gbs_api\",\n" +
            "    \"offers\": [\n" +
            "     {\n" +
            "      \"finskyOfferType\": 1,\n" +
            "      \"listPrice\": {\n" +
            "       \"amountInMicros\": 1.77E9,\n" +
            "       \"currencyCode\": \"INR\"\n" +
            "      },\n" +
            "      \"retailPrice\": {\n" +
            "       \"amountInMicros\": 1.77E9,\n" +
            "       \"currencyCode\": \"INR\"\n" +
            "      }\n" +
            "     }\n" +
            "    ]\n" +
            "   },\n" +
            "   \"accessInfo\": {\n" +
            "    \"country\": \"IN\",\n" +
            "    \"viewability\": \"PARTIAL\",\n" +
            "    \"embeddable\": true,\n" +
            "    \"publicDomain\": false,\n" +
            "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "    \"epub\": {\n" +
            "     \"isAvailable\": true\n" +
            "    },\n" +
            "    \"pdf\": {\n" +
            "     \"isAvailable\": true\n" +
            "    },\n" +
            "    \"webReaderLink\": \"http://play.google.com/books/reader?id=zWndz5OpUzgC&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "    \"accessViewStatus\": \"SAMPLE\",\n" +
            "    \"quoteSharingAllowed\": false\n" +
            "   },\n" +
            "   \"searchInfo\": {\n" +
            "    \"textSnippet\": \"Now updated for HTML5, the second edition of this hands-on guide shows you how to use open source web standards to design and build apps that can be adapted for any Android device.\"\n" +
            "   }\n" +
            "  },\n" +
            "  {\n" +
            "   \"kind\": \"books#volume\",\n" +
            "   \"id\": \"zDibrpXTfxMC\",\n" +
            "   \"etag\": \"xDpZGzvzwi0\",\n" +
            "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/zDibrpXTfxMC\",\n" +
            "   \"volumeInfo\": {\n" +
            "    \"title\": \"Android Forensics\",\n" +
            "    \"subtitle\": \"Investigation, Analysis, and Mobile Security for Google Android\",\n" +
            "    \"authors\": [\n" +
            "     \"Andrew Hoog\"\n" +
            "    ],\n" +
            "    \"publisher\": \"Elsevier\",\n" +
            "    \"publishedDate\": \"2011\",\n" +
            "    \"description\": \"The open source nature of the platform has not only established a new direction for the industry, but enables a developer or forensic analyst to understand the device at the most fundamental level. Android Forensics covers an open source mobile device platform based on the Linux 2.6 kernel and managed by the Open Handset Alliance. The Android platform is a major source of digital forensic investigation and analysis. This book provides a thorough review of the Android platform including supported hardware devices, the structure of the Android development project and implementation of core services (wireless communication, data storage and other low-level functions). Finally, it will focus on teaching readers how to apply actual forensic techniques to recover data. Ability to forensically acquire Android devices using the techniques outlined in the book Detailed information about Android applications needed for forensics investigations Important information about SQLite, a file based structured data storage relevant for both Android and many other platforms.\",\n" +
            "    \"industryIdentifiers\": [\n" +
            "     {\n" +
            "      \"type\": \"ISBN_13\",\n" +
            "      \"identifier\": \"9781597496513\"\n" +
            "     },\n" +
            "     {\n" +
            "      \"type\": \"ISBN_10\",\n" +
            "      \"identifier\": \"1597496510\"\n" +
            "     }\n" +
            "    ],\n" +
            "    \"readingModes\": {\n" +
            "     \"text\": false,\n" +
            "     \"image\": true\n" +
            "    },\n" +
            "    \"pageCount\": 372,\n" +
            "    \"printType\": \"BOOK\",\n" +
            "    \"categories\": [\n" +
            "     \"Computers\"\n" +
            "    ],\n" +
            "    \"maturityRating\": \"NOT_MATURE\",\n" +
            "    \"allowAnonLogging\": false,\n" +
            "    \"contentVersion\": \"preview-1.0.0\",\n" +
            "    \"panelizationSummary\": {\n" +
            "     \"containsEpubBubbles\": false,\n" +
            "     \"containsImageBubbles\": false\n" +
            "    },\n" +
            "    \"imageLinks\": {\n" +
            "     \"smallThumbnail\": \"http://books.google.com/books/content?id=zDibrpXTfxMC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "     \"thumbnail\": \"http://books.google.com/books/content?id=zDibrpXTfxMC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "    },\n" +
            "    \"language\": \"en\",\n" +
            "    \"previewLink\": \"http://books.google.co.in/books?id=zDibrpXTfxMC&printsec=frontcover&dq=android&hl=&cd=10&source=gbs_api\",\n" +
            "    \"infoLink\": \"http://books.google.co.in/books?id=zDibrpXTfxMC&dq=android&hl=&source=gbs_api\",\n" +
            "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/Android_Forensics.html?hl=&id=zDibrpXTfxMC\"\n" +
            "   },\n" +
            "   \"saleInfo\": {\n" +
            "    \"country\": \"IN\",\n" +
            "    \"saleability\": \"NOT_FOR_SALE\",\n" +
            "    \"isEbook\": false\n" +
            "   },\n" +
            "   \"accessInfo\": {\n" +
            "    \"country\": \"IN\",\n" +
            "    \"viewability\": \"PARTIAL\",\n" +
            "    \"embeddable\": true,\n" +
            "    \"publicDomain\": false,\n" +
            "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "    \"epub\": {\n" +
            "     \"isAvailable\": false\n" +
            "    },\n" +
            "    \"pdf\": {\n" +
            "     \"isAvailable\": false\n" +
            "    },\n" +
            "    \"webReaderLink\": \"http://play.google.com/books/reader?id=zDibrpXTfxMC&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "    \"accessViewStatus\": \"SAMPLE\",\n" +
            "    \"quoteSharingAllowed\": false\n" +
            "   },\n" +
            "   \"searchInfo\": {\n" +
            "    \"textSnippet\": \"This book provides a thorough review of the Android platform including supported hardware devices, the structure of the Android development project and implementation of core services (wireless communication, data storage and other low ...\"\n" +
            "   }\n" +
            "  }\n" +
            " ]\n" +
            "}";
    public static ArrayList<BookList> extractBookList () {
        ArrayList<BookList> bookLists = new ArrayList<>();

        try {
            JSONObject baseJsonResponse = new JSONObject(SAMPLE_JSON_RESPONSE);
            JSONArray items = baseJsonResponse.getJSONArray("items");

            for(int i=0;i<items.length();i++) {
                JSONObject currentBook = items.getJSONObject(i);
                JSONObject volumeInfo = currentBook.getJSONObject("volumeInfo");
                String title = volumeInfo.getString("title");
                String author_name;
                if(volumeInfo.optJSONArray("authors")!=null) {
                    JSONArray author = volumeInfo.getJSONArray("authors");
                    author_name = author.getString(0);
                } else {
                    author_name = "Not available!";
                }
                String preview_url = volumeInfo.getString("previewLink");
                JSONObject accessInfo = currentBook.getJSONObject("accessInfo");
                JSONObject downloadInfo = accessInfo.getJSONObject("pdf");
                String downloadOrViewUrl;
                String downloadAvailable;

                if(downloadInfo.has("downloadLink")) {
                    downloadAvailable = "YES";
                    downloadOrViewUrl = downloadInfo.getString("downloadLink");
                } else {
                    downloadAvailable = "NO";
                    downloadOrViewUrl = accessInfo.getString("webReaderLink");
                }

                JSONObject imageLinks = volumeInfo.getJSONObject("imageLinks");
                String imageUrl = imageLinks.getString("smallThumbnail");

                BookList bookList = new BookList(imageUrl,title,author_name,preview_url,downloadAvailable,downloadOrViewUrl);
                bookLists.add(bookList);

            }

        } catch (JSONException e) {
            Log.e("QueryUtils", "Problem parsing the JSON results", e);
        }

        return bookLists;
    }



}


