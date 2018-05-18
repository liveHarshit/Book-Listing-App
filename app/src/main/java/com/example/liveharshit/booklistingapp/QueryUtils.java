package com.example.liveharshit.booklistingapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.renderscript.Sampler;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class QueryUtils {

    private QueryUtils () {

    }


    private static final String SAMPLE_JSON_RESPONSE = "{\n" +
            " \"kind\": \"books#volumes\",\n" +
            " \"totalItems\": 3981,\n" +
            " \"items\": [\n" +
            "  {\n" +
            "   \"kind\": \"books#volume\",\n" +
            "   \"id\": \"qBxhhMkSLRMC\",\n" +
            "   \"etag\": \"AKVsOsYwK2Q\",\n" +
            "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/qBxhhMkSLRMC\",\n" +
            "   \"volumeInfo\": {\n" +
            "    \"title\": \"Trippings in Author-land\",\n" +
            "    \"authors\": [\n" +
            "     \"Emily Chubbuck Judson\"\n" +
            "    ],\n" +
            "    \"publishedDate\": \"1846\",\n" +
            "    \"industryIdentifiers\": [\n" +
            "     {\n" +
            "      \"type\": \"OTHER\",\n" +
            "      \"identifier\": \"HARVARD:32044019377837\"\n" +
            "     }\n" +
            "    ],\n" +
            "    \"readingModes\": {\n" +
            "     \"text\": false,\n" +
            "     \"image\": true\n" +
            "    },\n" +
            "    \"pageCount\": 281,\n" +
            "    \"printType\": \"BOOK\",\n" +
            "    \"maturityRating\": \"NOT_MATURE\",\n" +
            "    \"allowAnonLogging\": false,\n" +
            "    \"contentVersion\": \"0.2.1.0.full.1\",\n" +
            "    \"panelizationSummary\": {\n" +
            "     \"containsEpubBubbles\": false,\n" +
            "     \"containsImageBubbles\": false\n" +
            "    },\n" +
            "    \"imageLinks\": {\n" +
            "     \"smallThumbnail\": \"http://books.google.com/books/content?id=qBxhhMkSLRMC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "     \"thumbnail\": \"http://books.google.com/books/content?id=qBxhhMkSLRMC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "    },\n" +
            "    \"language\": \"en\",\n" +
            "    \"previewLink\": \"http://books.google.co.in/books?id=qBxhhMkSLRMC&pg=PA98&dq=flowers+inauthor&hl=&cd=1&source=gbs_api\",\n" +
            "    \"infoLink\": \"https://play.google.com/store/books/details?id=qBxhhMkSLRMC&source=gbs_api\",\n" +
            "    \"canonicalVolumeLink\": \"https://market.android.com/details?id=book-qBxhhMkSLRMC\"\n" +
            "   },\n" +
            "   \"saleInfo\": {\n" +
            "    \"country\": \"IN\",\n" +
            "    \"saleability\": \"FREE\",\n" +
            "    \"isEbook\": true,\n" +
            "    \"buyLink\": \"https://play.google.com/store/books/details?id=qBxhhMkSLRMC&rdid=book-qBxhhMkSLRMC&rdot=1&source=gbs_api\"\n" +
            "   },\n" +
            "   \"accessInfo\": {\n" +
            "    \"country\": \"IN\",\n" +
            "    \"viewability\": \"ALL_PAGES\",\n" +
            "    \"embeddable\": true,\n" +
            "    \"publicDomain\": true,\n" +
            "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "    \"epub\": {\n" +
            "     \"isAvailable\": false,\n" +
            "     \"downloadLink\": \"http://books.google.co.in/books/download/Trippings_in_Author_land.epub?id=qBxhhMkSLRMC&hl=&output=epub&source=gbs_api\"\n" +
            "    },\n" +
            "    \"pdf\": {\n" +
            "     \"isAvailable\": true,\n" +
            "     \"downloadLink\": \"http://books.google.co.in/books/download/Trippings_in_Author_land.pdf?id=qBxhhMkSLRMC&hl=&output=pdf&sig=ACfU3U2ecOY2qN_n_Yb4XgK-xWCBidj18g&source=gbs_api\"\n" +
            "    },\n" +
            "    \"webReaderLink\": \"http://play.google.com/books/reader?id=qBxhhMkSLRMC&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "    \"accessViewStatus\": \"FULL_PUBLIC_DOMAIN\",\n" +
            "    \"quoteSharingAllowed\": false\n" +
            "   },\n" +
            "   \"searchInfo\": {\n" +
            "    \"textSnippet\": \"The trees budded and leaved ; \\u003cb\\u003eflowers\\u003c/b\\u003e bloomed and faded, leaving their places \\u003cbr\\u003e\\nto brighter \\u003cb\\u003eflowers\\u003c/b\\u003e still ; the brooks frolicked and jostled their tiny drops together ; \\u003cbr\\u003e\\nand the birds answered back from ten thousand fresh green coverts with startling\\u003cbr\\u003e\\n&nbsp;...\"\n" +
            "   }\n" +
            "  },\n" +
            "  {\n" +
            "   \"kind\": \"books#volume\",\n" +
            "   \"id\": \"ELARIo1Xb1sC\",\n" +
            "   \"etag\": \"cOyGW9z8U4M\",\n" +
            "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/ELARIo1Xb1sC\",\n" +
            "   \"volumeInfo\": {\n" +
            "    \"title\": \"Freedom's Orator\",\n" +
            "    \"subtitle\": \"Mario Savio and the Radical Legacy of the 1960s\",\n" +
            "    \"authors\": [\n" +
            "     \"Robert Cohen\"\n" +
            "    ],\n" +
            "    \"publisher\": \"Oxford University Press\",\n" +
            "    \"publishedDate\": \"2009-08-27\",\n" +
            "    \"description\": \"Here is the first biography of Mario Savio, the brilliant leader of Berkeley's Free Speech Movement, the largest and most disruptive student rebellion in American history. Savio risked his life to register black voters in Mississippi in the Freedom Summer of 1964 and did more than anyone to bring daring forms of non-violent protest from the civil rights movement to the struggle for free speech and academic freedom on American campuses. Drawing upon previously unavailable Savio papers, as well as oral histories from friends and fellow movement leaders, Freedom's Orator illuminates Mario's egalitarian leadership style, his remarkable eloquence, and the many ways he embodied the youthful idealism of the 1960s. The book also narrates, for the first time, his second phase of activism against \\\"Reaganite Imperialism\\\" in Central America and the corporatization of higher education. Including a generous selection of Savio's speeches, Freedom's Orator speaks with special relevance to a new generation of activists and to all who cherish the '60s and democratic ideals for which Savio fought so selflessly.\",\n" +
            "    \"industryIdentifiers\": [\n" +
            "     {\n" +
            "      \"type\": \"ISBN_10\",\n" +
            "      \"identifier\": \"0199766347\"\n" +
            "     },\n" +
            "     {\n" +
            "      \"type\": \"ISBN_13\",\n" +
            "      \"identifier\": \"9780199766345\"\n" +
            "     }\n" +
            "    ],\n" +
            "    \"readingModes\": {\n" +
            "     \"text\": true,\n" +
            "     \"image\": true\n" +
            "    },\n" +
            "    \"pageCount\": 544,\n" +
            "    \"printType\": \"BOOK\",\n" +
            "    \"categories\": [\n" +
            "     \"History\"\n" +
            "    ],\n" +
            "    \"maturityRating\": \"NOT_MATURE\",\n" +
            "    \"allowAnonLogging\": true,\n" +
            "    \"contentVersion\": \"0.7.3.0.preview.3\",\n" +
            "    \"panelizationSummary\": {\n" +
            "     \"containsEpubBubbles\": false,\n" +
            "     \"containsImageBubbles\": false\n" +
            "    },\n" +
            "    \"imageLinks\": {\n" +
            "     \"smallThumbnail\": \"http://books.google.com/books/content?id=ELARIo1Xb1sC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "     \"thumbnail\": \"http://books.google.com/books/content?id=ELARIo1Xb1sC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "    },\n" +
            "    \"language\": \"en\",\n" +
            "    \"previewLink\": \"http://books.google.co.in/books?id=ELARIo1Xb1sC&pg=PA478&dq=flowers+inauthor&hl=&cd=2&source=gbs_api\",\n" +
            "    \"infoLink\": \"https://play.google.com/store/books/details?id=ELARIo1Xb1sC&source=gbs_api\",\n" +
            "    \"canonicalVolumeLink\": \"https://market.android.com/details?id=book-ELARIo1Xb1sC\"\n" +
            "   },\n" +
            "   \"saleInfo\": {\n" +
            "    \"country\": \"IN\",\n" +
            "    \"saleability\": \"FOR_SALE\",\n" +
            "    \"isEbook\": true,\n" +
            "    \"listPrice\": {\n" +
            "     \"amount\": 588.19,\n" +
            "     \"currencyCode\": \"INR\"\n" +
            "    },\n" +
            "    \"retailPrice\": {\n" +
            "     \"amount\": 294.1,\n" +
            "     \"currencyCode\": \"INR\"\n" +
            "    },\n" +
            "    \"buyLink\": \"https://play.google.com/store/books/details?id=ELARIo1Xb1sC&rdid=book-ELARIo1Xb1sC&rdot=1&source=gbs_api\",\n" +
            "    \"offers\": [\n" +
            "     {\n" +
            "      \"finskyOfferType\": 1,\n" +
            "      \"listPrice\": {\n" +
            "       \"amountInMicros\": 5.8819E8,\n" +
            "       \"currencyCode\": \"INR\"\n" +
            "      },\n" +
            "      \"retailPrice\": {\n" +
            "       \"amountInMicros\": 2.941E8,\n" +
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
            "     \"isAvailable\": true,\n" +
            "     \"acsTokenLink\": \"http://books.google.co.in/books/download/Freedom_s_Orator-sample-epub.acsm?id=ELARIo1Xb1sC&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "    },\n" +
            "    \"pdf\": {\n" +
            "     \"isAvailable\": true,\n" +
            "     \"acsTokenLink\": \"http://books.google.co.in/books/download/Freedom_s_Orator-sample-pdf.acsm?id=ELARIo1Xb1sC&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "    },\n" +
            "    \"webReaderLink\": \"http://play.google.com/books/reader?id=ELARIo1Xb1sC&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "    \"accessViewStatus\": \"SAMPLE\",\n" +
            "    \"quoteSharingAllowed\": false\n" +
            "   },\n" +
            "   \"searchInfo\": {\n" +
            "    \"textSnippet\": \"Mario Savio, “3 a.m.,” unpublished poem, October 19, 1977, copy \\u003cb\\u003ein author&#39;s\\u003c/b\\u003e \\u003cbr\\u003e\\npossession. Savio&#39;s poems are the only ... “I believe in the coming of dead \\u003cbr\\u003e\\n\\u003cb\\u003eflowers\\u003c/b\\u003e,” unpublished poem, copy \\u003cb\\u003ein author&#39;s\\u003c/b\\u003e possession. 6. Mario Savio to Art \\u003cbr\\u003e\\nGatti, March&nbsp;...\"\n" +
            "   }\n" +
            "  },\n" +
            "  {\n" +
            "   \"kind\": \"books#volume\",\n" +
            "   \"id\": \"ybt2ho-JH6QC\",\n" +
            "   \"etag\": \"Hpv+SsiYeUk\",\n" +
            "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/ybt2ho-JH6QC\",\n" +
            "   \"volumeInfo\": {\n" +
            "    \"title\": \"Chadha\",\n" +
            "    \"subtitle\": \"The Story of an Epic Constitutional Struggle\",\n" +
            "    \"authors\": [\n" +
            "     \"Barbara Hinkson Craig\"\n" +
            "    ],\n" +
            "    \"publisher\": \"Univ of California Press\",\n" +
            "    \"publishedDate\": \"1990\",\n" +
            "    \"description\": \"Looks at how the case of a Kenyan student led to the ruling that the legislative veto in the Immigration and Naturalization Act is unconstitutional\",\n" +
            "    \"industryIdentifiers\": [\n" +
            "     {\n" +
            "      \"type\": \"ISBN_10\",\n" +
            "      \"identifier\": \"0520069552\"\n" +
            "     },\n" +
            "     {\n" +
            "      \"type\": \"ISBN_13\",\n" +
            "      \"identifier\": \"9780520069558\"\n" +
            "     }\n" +
            "    ],\n" +
            "    \"readingModes\": {\n" +
            "     \"text\": true,\n" +
            "     \"image\": true\n" +
            "    },\n" +
            "    \"pageCount\": 262,\n" +
            "    \"printType\": \"BOOK\",\n" +
            "    \"categories\": [\n" +
            "     \"History\"\n" +
            "    ],\n" +
            "    \"maturityRating\": \"NOT_MATURE\",\n" +
            "    \"allowAnonLogging\": false,\n" +
            "    \"contentVersion\": \"0.0.2.0.preview.3\",\n" +
            "    \"panelizationSummary\": {\n" +
            "     \"containsEpubBubbles\": false,\n" +
            "     \"containsImageBubbles\": false\n" +
            "    },\n" +
            "    \"imageLinks\": {\n" +
            "     \"smallThumbnail\": \"http://books.google.com/books/content?id=ybt2ho-JH6QC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "     \"thumbnail\": \"http://books.google.com/books/content?id=ybt2ho-JH6QC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "    },\n" +
            "    \"language\": \"en\",\n" +
            "    \"previewLink\": \"http://books.google.co.in/books?id=ybt2ho-JH6QC&pg=PA244&dq=flowers+inauthor&hl=&cd=3&source=gbs_api\",\n" +
            "    \"infoLink\": \"http://books.google.co.in/books?id=ybt2ho-JH6QC&dq=flowers+inauthor&hl=&source=gbs_api\",\n" +
            "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/Chadha.html?hl=&id=ybt2ho-JH6QC\"\n" +
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
            "     \"acsTokenLink\": \"http://books.google.co.in/books/download/Chadha-sample-epub.acsm?id=ybt2ho-JH6QC&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "    },\n" +
            "    \"pdf\": {\n" +
            "     \"isAvailable\": false\n" +
            "    },\n" +
            "    \"webReaderLink\": \"http://play.google.com/books/reader?id=ybt2ho-JH6QC&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "    \"accessViewStatus\": \"SAMPLE\",\n" +
            "    \"quoteSharingAllowed\": false\n" +
            "   },\n" +
            "   \"searchInfo\": {\n" +
            "    \"textSnippet\": \"Copy of Rodino letter, provided by Pohlmann, \\u003cb\\u003ein author&#39;s\\u003c/b\\u003e files. 43. Deportation \\u003cbr\\u003e\\nHearings, pp. ... 5. 49. Ibid., pp. 1-2. 50. Copy of Chadha&#39;s deportation notice \\u003cb\\u003ein\\u003c/b\\u003e \\u003cbr\\u003e\\n\\u003cb\\u003eauthor&#39;s\\u003c/b\\u003e files. 51. ... (Hereafter cited as \\u003cb\\u003eFlowers\\u003c/b\\u003e Hearings.) 3. Ibid., p. 140. 4. Ibid., \\u003cbr\\u003e\\np.\"\n" +
            "   }\n" +
            "  },\n" +
            "  {\n" +
            "   \"kind\": \"books#volume\",\n" +
            "   \"id\": \"2SYhAQAAIAAJ\",\n" +
            "   \"etag\": \"V+5rNjVux6I\",\n" +
            "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/2SYhAQAAIAAJ\",\n" +
            "   \"volumeInfo\": {\n" +
            "    \"title\": \"Catalog of Copyright Entries\",\n" +
            "    \"subtitle\": \"Third series\",\n" +
            "    \"publishedDate\": \"1951\",\n" +
            "    \"industryIdentifiers\": [\n" +
            "     {\n" +
            "      \"type\": \"OTHER\",\n" +
            "      \"identifier\": \"STANFORD:36105006281351\"\n" +
            "     }\n" +
            "    ],\n" +
            "    \"readingModes\": {\n" +
            "     \"text\": false,\n" +
            "     \"image\": true\n" +
            "    },\n" +
            "    \"printType\": \"BOOK\",\n" +
            "    \"categories\": [\n" +
            "     \"Copyright\"\n" +
            "    ],\n" +
            "    \"maturityRating\": \"NOT_MATURE\",\n" +
            "    \"allowAnonLogging\": false,\n" +
            "    \"contentVersion\": \"1.1.1.0.full.1\",\n" +
            "    \"imageLinks\": {\n" +
            "     \"smallThumbnail\": \"http://books.google.com/books/content?id=2SYhAQAAIAAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "     \"thumbnail\": \"http://books.google.com/books/content?id=2SYhAQAAIAAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "    },\n" +
            "    \"language\": \"en\",\n" +
            "    \"previewLink\": \"http://books.google.co.in/books?id=2SYhAQAAIAAJ&pg=PA148&dq=flowers+inauthor&hl=&cd=4&source=gbs_api\",\n" +
            "    \"infoLink\": \"https://play.google.com/store/books/details?id=2SYhAQAAIAAJ&source=gbs_api\",\n" +
            "    \"canonicalVolumeLink\": \"https://market.android.com/details?id=book-2SYhAQAAIAAJ\"\n" +
            "   },\n" +
            "   \"saleInfo\": {\n" +
            "    \"country\": \"IN\",\n" +
            "    \"saleability\": \"FREE\",\n" +
            "    \"isEbook\": true,\n" +
            "    \"buyLink\": \"https://play.google.com/store/books/details?id=2SYhAQAAIAAJ&rdid=book-2SYhAQAAIAAJ&rdot=1&source=gbs_api\"\n" +
            "   },\n" +
            "   \"accessInfo\": {\n" +
            "    \"country\": \"IN\",\n" +
            "    \"viewability\": \"ALL_PAGES\",\n" +
            "    \"embeddable\": true,\n" +
            "    \"publicDomain\": true,\n" +
            "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "    \"epub\": {\n" +
            "     \"isAvailable\": false\n" +
            "    },\n" +
            "    \"pdf\": {\n" +
            "     \"isAvailable\": false\n" +
            "    },\n" +
            "    \"webReaderLink\": \"http://play.google.com/books/reader?id=2SYhAQAAIAAJ&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "    \"accessViewStatus\": \"FULL_PUBLIC_DOMAIN\",\n" +
            "    \"quoteSharingAllowed\": false\n" +
            "   },\n" +
            "   \"searchInfo\": {\n" +
            "    \"textSnippet\": \"DISNEY (WALT) PRODUCTIONS. Alice in Wonderland meets the enchanted \\u003cbr\\u003e\\n\\u003cb\\u003eflowers\\u003c/b\\u003e. ... Burbank, Calif.; 5Sep51; K30137. White Rabbit and the \\u003cb\\u003eflowers\\u003c/b\\u003e. ... 7 x \\u003cbr\\u003e\\n7 \\u003cb\\u003ein. Author\\u003c/b\\u003e of reproduction: Brown and Bigelow. © Brown &amp; Bigelow, St. Paul;&nbsp;...\"\n" +
            "   }\n" +
            "  },\n" +
            "  {\n" +
            "   \"kind\": \"books#volume\",\n" +
            "   \"id\": \"beBEDwAAQBAJ\",\n" +
            "   \"etag\": \"yAjmn0yUey4\",\n" +
            "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/beBEDwAAQBAJ\",\n" +
            "   \"volumeInfo\": {\n" +
            "    \"title\": \"Rise to Hope\",\n" +
            "    \"subtitle\": \"She Fell From Heaven... Now She's Back\",\n" +
            "    \"authors\": [\n" +
            "     \"A.J. Flowers\"\n" +
            "    ],\n" +
            "    \"publisher\": \"A.J. Flowers\",\n" +
            "    \"publishedDate\": \"2017-10-29\",\n" +
            "    \"description\": \"To become Queen, she had to fall from heaven. But now that she's back, can she take the throne? Standalone Capable! In the stunning sequel to Fallen to Grace, Azrael must face a new world with new masters. She’s the Queen of Celestia—or so the Council of angels wish her to believe. The Seraphim, the true ruler of Celestia, holds Gabriel captive and tinkers with dark magic. Azrael must master her powers and her heart like never before in order to save Gabriel and lead a coup against the Seraphim. She’ll find an unlikely ally in a mutated girl who once took everything from her… Will it be in Azrael’s power to forgive?\",\n" +
            "    \"readingModes\": {\n" +
            "     \"text\": true,\n" +
            "     \"image\": true\n" +
            "    },\n" +
            "    \"pageCount\": 248,\n" +
            "    \"printType\": \"BOOK\",\n" +
            "    \"maturityRating\": \"NOT_MATURE\",\n" +
            "    \"allowAnonLogging\": false,\n" +
            "    \"contentVersion\": \"1.1.1.0.preview.3\",\n" +
            "    \"panelizationSummary\": {\n" +
            "     \"containsEpubBubbles\": false,\n" +
            "     \"containsImageBubbles\": false\n" +
            "    },\n" +
            "    \"imageLinks\": {\n" +
            "     \"smallThumbnail\": \"http://books.google.com/books/content?id=beBEDwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "     \"thumbnail\": \"http://books.google.com/books/content?id=beBEDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "    },\n" +
            "    \"language\": \"en\",\n" +
            "    \"previewLink\": \"http://books.google.co.in/books?id=beBEDwAAQBAJ&printsec=frontcover&dq=flowers+inauthor&hl=&cd=5&source=gbs_api\",\n" +
            "    \"infoLink\": \"https://play.google.com/store/books/details?id=beBEDwAAQBAJ&source=gbs_api\",\n" +
            "    \"canonicalVolumeLink\": \"https://market.android.com/details?id=book-beBEDwAAQBAJ\"\n" +
            "   },\n" +
            "   \"saleInfo\": {\n" +
            "    \"country\": \"IN\",\n" +
            "    \"saleability\": \"FOR_SALE\",\n" +
            "    \"isEbook\": true,\n" +
            "    \"listPrice\": {\n" +
            "     \"amount\": 616.91,\n" +
            "     \"currencyCode\": \"INR\"\n" +
            "    },\n" +
            "    \"retailPrice\": {\n" +
            "     \"amount\": 308.46,\n" +
            "     \"currencyCode\": \"INR\"\n" +
            "    },\n" +
            "    \"buyLink\": \"https://play.google.com/store/books/details?id=beBEDwAAQBAJ&rdid=book-beBEDwAAQBAJ&rdot=1&source=gbs_api\",\n" +
            "    \"offers\": [\n" +
            "     {\n" +
            "      \"finskyOfferType\": 1,\n" +
            "      \"listPrice\": {\n" +
            "       \"amountInMicros\": 6.1691E8,\n" +
            "       \"currencyCode\": \"INR\"\n" +
            "      },\n" +
            "      \"retailPrice\": {\n" +
            "       \"amountInMicros\": 3.0846E8,\n" +
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
            "     \"isAvailable\": true,\n" +
            "     \"acsTokenLink\": \"http://books.google.co.in/books/download/Rise_to_Hope-sample-epub.acsm?id=beBEDwAAQBAJ&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "    },\n" +
            "    \"pdf\": {\n" +
            "     \"isAvailable\": true,\n" +
            "     \"acsTokenLink\": \"http://books.google.co.in/books/download/Rise_to_Hope-sample-pdf.acsm?id=beBEDwAAQBAJ&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "    },\n" +
            "    \"webReaderLink\": \"http://play.google.com/books/reader?id=beBEDwAAQBAJ&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "    \"accessViewStatus\": \"SAMPLE\",\n" +
            "    \"quoteSharingAllowed\": false\n" +
            "   },\n" +
            "   \"searchInfo\": {\n" +
            "    \"textSnippet\": \"To become Queen, she had to fall from heaven.\"\n" +
            "   }\n" +
            "  },\n" +
            "  {\n" +
            "   \"kind\": \"books#volume\",\n" +
            "   \"id\": \"pIs9Em38dAoC\",\n" +
            "   \"etag\": \"bl+9ze2Hb60\",\n" +
            "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/pIs9Em38dAoC\",\n" +
            "   \"volumeInfo\": {\n" +
            "    \"title\": \"The Play of Daniel Keyes' Flowers for Algernon\",\n" +
            "    \"authors\": [\n" +
            "     \"Bert Coules\",\n" +
            "     \"Daniel Keyes\"\n" +
            "    ],\n" +
            "    \"publisher\": \"Heinemann\",\n" +
            "    \"publishedDate\": \"1993\",\n" +
            "    \"description\": \"The Heinemann Plays series offers contemporary drama and classic plays in durable classroom editions. Many have large casts and an equal mix of boy and girl parts. This play is a dramatization of Daniel Keyes's story about a retarded adult who desperately wants to be able to read and write.\",\n" +
            "    \"industryIdentifiers\": [\n" +
            "     {\n" +
            "      \"type\": \"ISBN_10\",\n" +
            "      \"identifier\": \"0435232932\"\n" +
            "     },\n" +
            "     {\n" +
            "      \"type\": \"ISBN_13\",\n" +
            "      \"identifier\": \"9780435232931\"\n" +
            "     }\n" +
            "    ],\n" +
            "    \"readingModes\": {\n" +
            "     \"text\": false,\n" +
            "     \"image\": true\n" +
            "    },\n" +
            "    \"pageCount\": 128,\n" +
            "    \"printType\": \"BOOK\",\n" +
            "    \"categories\": [\n" +
            "     \"English drama\"\n" +
            "    ],\n" +
            "    \"averageRating\": 4.5,\n" +
            "    \"ratingsCount\": 3,\n" +
            "    \"maturityRating\": \"NOT_MATURE\",\n" +
            "    \"allowAnonLogging\": false,\n" +
            "    \"contentVersion\": \"preview-1.0.0\",\n" +
            "    \"imageLinks\": {\n" +
            "     \"smallThumbnail\": \"http://books.google.com/books/content?id=pIs9Em38dAoC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "     \"thumbnail\": \"http://books.google.com/books/content?id=pIs9Em38dAoC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "    },\n" +
            "    \"language\": \"en\",\n" +
            "    \"previewLink\": \"http://books.google.co.in/books?id=pIs9Em38dAoC&printsec=frontcover&dq=flowers+inauthor&hl=&cd=6&source=gbs_api\",\n" +
            "    \"infoLink\": \"http://books.google.co.in/books?id=pIs9Em38dAoC&dq=flowers+inauthor&hl=&source=gbs_api\",\n" +
            "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/The_Play_of_Daniel_Keyes_Flowers_for_Alg.html?hl=&id=pIs9Em38dAoC\"\n" +
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
            "    \"webReaderLink\": \"http://play.google.com/books/reader?id=pIs9Em38dAoC&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "    \"accessViewStatus\": \"SAMPLE\",\n" +
            "    \"quoteSharingAllowed\": false\n" +
            "   },\n" +
            "   \"searchInfo\": {\n" +
            "    \"textSnippet\": \"This is a powerful dramatisation of Daniel Keyes&#39;s perceptive and sad novel.\"\n" +
            "   }\n" +
            "  },\n" +
            "  {\n" +
            "   \"kind\": \"books#volume\",\n" +
            "   \"id\": \"EWhGAQAAMAAJ\",\n" +
            "   \"etag\": \"OIwqAm9vLOA\",\n" +
            "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/EWhGAQAAMAAJ\",\n" +
            "   \"volumeInfo\": {\n" +
            "    \"title\": \"The Naturalist\",\n" +
            "    \"publishedDate\": \"1888\",\n" +
            "    \"industryIdentifiers\": [\n" +
            "     {\n" +
            "      \"type\": \"OTHER\",\n" +
            "      \"identifier\": \"UCBK:C063039377\"\n" +
            "     }\n" +
            "    ],\n" +
            "    \"readingModes\": {\n" +
            "     \"text\": false,\n" +
            "     \"image\": false\n" +
            "    },\n" +
            "    \"printType\": \"BOOK\",\n" +
            "    \"categories\": [\n" +
            "     \"Geology\"\n" +
            "    ],\n" +
            "    \"maturityRating\": \"NOT_MATURE\",\n" +
            "    \"allowAnonLogging\": false,\n" +
            "    \"contentVersion\": \"0.0.2.0.preview.0\",\n" +
            "    \"panelizationSummary\": {\n" +
            "     \"containsEpubBubbles\": false,\n" +
            "     \"containsImageBubbles\": false\n" +
            "    },\n" +
            "    \"imageLinks\": {\n" +
            "     \"smallThumbnail\": \"http://books.google.com/books/content?id=EWhGAQAAMAAJ&printsec=frontcover&img=1&zoom=5&source=gbs_api\",\n" +
            "     \"thumbnail\": \"http://books.google.com/books/content?id=EWhGAQAAMAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api\"\n" +
            "    },\n" +
            "    \"language\": \"en\",\n" +
            "    \"previewLink\": \"http://books.google.co.in/books?id=EWhGAQAAMAAJ&q=flowers+inauthor&dq=flowers+inauthor&hl=&cd=7&source=gbs_api\",\n" +
            "    \"infoLink\": \"http://books.google.co.in/books?id=EWhGAQAAMAAJ&dq=flowers+inauthor&hl=&source=gbs_api\",\n" +
            "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/The_Naturalist.html?hl=&id=EWhGAQAAMAAJ\"\n" +
            "   },\n" +
            "   \"saleInfo\": {\n" +
            "    \"country\": \"IN\",\n" +
            "    \"saleability\": \"NOT_FOR_SALE\",\n" +
            "    \"isEbook\": false\n" +
            "   },\n" +
            "   \"accessInfo\": {\n" +
            "    \"country\": \"IN\",\n" +
            "    \"viewability\": \"NO_PAGES\",\n" +
            "    \"embeddable\": false,\n" +
            "    \"publicDomain\": false,\n" +
            "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "    \"epub\": {\n" +
            "     \"isAvailable\": false\n" +
            "    },\n" +
            "    \"pdf\": {\n" +
            "     \"isAvailable\": false\n" +
            "    },\n" +
            "    \"webReaderLink\": \"http://play.google.com/books/reader?id=EWhGAQAAMAAJ&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "    \"accessViewStatus\": \"NONE\",\n" +
            "    \"quoteSharingAllowed\": false\n" +
            "   },\n" +
            "   \"searchInfo\": {\n" +
            "    \"textSnippet\": \"[Meligethes erythropus Gyll., abundant in Langworth Wood near Lincoln, on \\u003cbr\\u003e\\nPotentilla tormentilla, and sparingly on strawberry \\u003cb\\u003eflowers in author&#39;s\\u003c/b\\u003e garden at \\u003cbr\\u003e\\nLincoln; Repton and Chat Moss; and Castle Mill, near Manchester, on \\u003cbr\\u003e\\nGaleobdolon&nbsp;...\"\n" +
            "   }\n" +
            "  },\n" +
            "  {\n" +
            "   \"kind\": \"books#volume\",\n" +
            "   \"id\": \"3trRoAEACAAJ\",\n" +
            "   \"etag\": \"fTxPl9If9DE\",\n" +
            "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/3trRoAEACAAJ\",\n" +
            "   \"volumeInfo\": {\n" +
            "    \"title\": \"Sidewalk Flowers\",\n" +
            "    \"authors\": [\n" +
            "     \"JonArno Lawson\",\n" +
            "     \"Sydney Smith\"\n" +
            "    ],\n" +
            "    \"publishedDate\": \"2015\",\n" +
            "    \"description\": \"A little girl collects wildflowers while walking through town with her father.\",\n" +
            "    \"industryIdentifiers\": [\n" +
            "     {\n" +
            "      \"type\": \"ISBN_10\",\n" +
            "      \"identifier\": \"1554984319\"\n" +
            "     },\n" +
            "     {\n" +
            "      \"type\": \"ISBN_13\",\n" +
            "      \"identifier\": \"9781554984312\"\n" +
            "     }\n" +
            "    ],\n" +
            "    \"readingModes\": {\n" +
            "     \"text\": false,\n" +
            "     \"image\": false\n" +
            "    },\n" +
            "    \"pageCount\": 32,\n" +
            "    \"printType\": \"BOOK\",\n" +
            "    \"categories\": [\n" +
            "     \"Juvenile Fiction\"\n" +
            "    ],\n" +
            "    \"averageRating\": 4.0,\n" +
            "    \"ratingsCount\": 3,\n" +
            "    \"maturityRating\": \"NOT_MATURE\",\n" +
            "    \"allowAnonLogging\": false,\n" +
            "    \"contentVersion\": \"preview-1.0.0\",\n" +
            "    \"panelizationSummary\": {\n" +
            "     \"containsEpubBubbles\": false,\n" +
            "     \"containsImageBubbles\": false\n" +
            "    },\n" +
            "    \"imageLinks\": {\n" +
            "     \"smallThumbnail\": \"http://books.google.com/books/content?id=3trRoAEACAAJ&printsec=frontcover&img=1&zoom=5&source=gbs_api\",\n" +
            "     \"thumbnail\": \"http://books.google.com/books/content?id=3trRoAEACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api\"\n" +
            "    },\n" +
            "    \"language\": \"en\",\n" +
            "    \"previewLink\": \"http://books.google.co.in/books?id=3trRoAEACAAJ&dq=flowers+inauthor&hl=&cd=8&source=gbs_api\",\n" +
            "    \"infoLink\": \"http://books.google.co.in/books?id=3trRoAEACAAJ&dq=flowers+inauthor&hl=&source=gbs_api\",\n" +
            "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/Sidewalk_Flowers.html?hl=&id=3trRoAEACAAJ\"\n" +
            "   },\n" +
            "   \"saleInfo\": {\n" +
            "    \"country\": \"IN\",\n" +
            "    \"saleability\": \"NOT_FOR_SALE\",\n" +
            "    \"isEbook\": false\n" +
            "   },\n" +
            "   \"accessInfo\": {\n" +
            "    \"country\": \"IN\",\n" +
            "    \"viewability\": \"NO_PAGES\",\n" +
            "    \"embeddable\": false,\n" +
            "    \"publicDomain\": false,\n" +
            "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "    \"epub\": {\n" +
            "     \"isAvailable\": false\n" +
            "    },\n" +
            "    \"pdf\": {\n" +
            "     \"isAvailable\": false\n" +
            "    },\n" +
            "    \"webReaderLink\": \"http://play.google.com/books/reader?id=3trRoAEACAAJ&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "    \"accessViewStatus\": \"NONE\",\n" +
            "    \"quoteSharingAllowed\": false\n" +
            "   },\n" +
            "   \"searchInfo\": {\n" +
            "    \"textSnippet\": \"A little girl collects wildflowers while walking through town with her father.\"\n" +
            "   }\n" +
            "  },\n" +
            "  {\n" +
            "   \"kind\": \"books#volume\",\n" +
            "   \"id\": \"l4aXgduXgwUC\",\n" +
            "   \"etag\": \"lE3HdgrSMrs\",\n" +
            "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/l4aXgduXgwUC\",\n" +
            "   \"volumeInfo\": {\n" +
            "    \"title\": \"Full Many a Flower\",\n" +
            "    \"authors\": [\n" +
            "     \"Ruby Dayton\"\n" +
            "    ],\n" +
            "    \"publisher\": \"iUniverse\",\n" +
            "    \"publishedDate\": \"2000-09-01\",\n" +
            "    \"description\": \"In the aftermath of the Great Depression, two year old Molly Whittaker's mother dies and leaves her in the care of her father, Truman, and her two brothers. Truman is desperate to keep his family together but when World War 2 begins, his older son joins and his younger son takes residence with his uncle. Truman and Molly roam the banks of the Mississippi river, he works clearing new ground and picking cotton until he gets a job operating a ferry. But, after a steamer collides with his vessel he fears for Molly's life and tries to find work elsewhere. Truman meets with a farm couple and they persuaded him to leave Molly with them. After a few years, Truman returns with a gypsy wife and her three adolescent sons. Molly is torn from a caring home and thrust into the clutches of this strange family. The Whittaker's take to the road as migrant field workers. A tent provides the only roof over their heads. Periodically, they miscalculate the harvest seasons and fine themselves destitute and near starvation. Truman soon discovers Manita ,his wife, is a soliciting prostitute and chooses to ignore the fact due to the much needed money. During a harrowing drunken episode, Manita pins Truman to the floor with a knife though his chest. Molly witnesses the event. At eight she is orphaned. Molly suffers bells palsy, leaving her face distorted. She refuses to speak. A mute, her teacher labels her incapable of learning and sends her home. Molly grows up illiterate. After the war is over, she comes to live with her brother and his wife, in the foothills of the Appalachian mountains. There, Molly triumphs over her years of adversity and becomes a prominent southern artist. She acquires an education and finds romance, love and stability..\",\n" +
            "    \"industryIdentifiers\": [\n" +
            "     {\n" +
            "      \"type\": \"ISBN_13\",\n" +
            "      \"identifier\": \"9780595138135\"\n" +
            "     },\n" +
            "     {\n" +
            "      \"type\": \"ISBN_10\",\n" +
            "      \"identifier\": \"0595138136\"\n" +
            "     }\n" +
            "    ],\n" +
            "    \"readingModes\": {\n" +
            "     \"text\": true,\n" +
            "     \"image\": true\n" +
            "    },\n" +
            "    \"pageCount\": 372,\n" +
            "    \"printType\": \"BOOK\",\n" +
            "    \"categories\": [\n" +
            "     \"Fiction\"\n" +
            "    ],\n" +
            "    \"maturityRating\": \"NOT_MATURE\",\n" +
            "    \"allowAnonLogging\": false,\n" +
            "    \"contentVersion\": \"2.3.3.0.preview.3\",\n" +
            "    \"imageLinks\": {\n" +
            "     \"smallThumbnail\": \"http://books.google.com/books/content?id=l4aXgduXgwUC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "     \"thumbnail\": \"http://books.google.com/books/content?id=l4aXgduXgwUC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "    },\n" +
            "    \"language\": \"en\",\n" +
            "    \"previewLink\": \"http://books.google.co.in/books?id=l4aXgduXgwUC&pg=PA361&dq=flowers+inauthor&hl=&cd=9&source=gbs_api\",\n" +
            "    \"infoLink\": \"http://books.google.co.in/books?id=l4aXgduXgwUC&dq=flowers+inauthor&hl=&source=gbs_api\",\n" +
            "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/Full_Many_a_Flower.html?hl=&id=l4aXgduXgwUC\"\n" +
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
            "     \"acsTokenLink\": \"http://books.google.co.in/books/download/Full_Many_a_Flower-sample-epub.acsm?id=l4aXgduXgwUC&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "    },\n" +
            "    \"pdf\": {\n" +
            "     \"isAvailable\": false\n" +
            "    },\n" +
            "    \"webReaderLink\": \"http://play.google.com/books/reader?id=l4aXgduXgwUC&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "    \"accessViewStatus\": \"SAMPLE\",\n" +
            "    \"quoteSharingAllowed\": false\n" +
            "   },\n" +
            "   \"searchInfo\": {\n" +
            "    \"textSnippet\": \"To further her understanding of writing she enrolled \\u003cb\\u003ein author\\u003c/b\\u003e Iean Ridley&#39;s fiction \\u003cbr\\u003e\\nwriting courses. There she begin Eull Many a \\u003cb\\u003eFlower\\u003c/b\\u003e, her first book of “faction”. In \\u003cbr\\u003e\\nthe aftermath of the Great Depression, two year old. 361 About the Author.\"\n" +
            "   }\n" +
            "  },\n" +
            "  {\n" +
            "   \"kind\": \"books#volume\",\n" +
            "   \"id\": \"ACoUAAAAYAAJ\",\n" +
            "   \"etag\": \"PRmjsK4jKZg\",\n" +
            "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/ACoUAAAAYAAJ\",\n" +
            "   \"volumeInfo\": {\n" +
            "    \"title\": \"The Register of the Kentucky Historical Society\",\n" +
            "    \"publishedDate\": \"1991\",\n" +
            "    \"industryIdentifiers\": [\n" +
            "     {\n" +
            "      \"type\": \"OTHER\",\n" +
            "      \"identifier\": \"UVA:X002525783\"\n" +
            "     }\n" +
            "    ],\n" +
            "    \"readingModes\": {\n" +
            "     \"text\": false,\n" +
            "     \"image\": false\n" +
            "    },\n" +
            "    \"printType\": \"BOOK\",\n" +
            "    \"categories\": [\n" +
            "     \"Kentucky\"\n" +
            "    ],\n" +
            "    \"maturityRating\": \"NOT_MATURE\",\n" +
            "    \"allowAnonLogging\": false,\n" +
            "    \"contentVersion\": \"0.0.1.0.preview.0\",\n" +
            "    \"imageLinks\": {\n" +
            "     \"smallThumbnail\": \"http://books.google.com/books/content?id=ACoUAAAAYAAJ&printsec=frontcover&img=1&zoom=5&source=gbs_api\",\n" +
            "     \"thumbnail\": \"http://books.google.com/books/content?id=ACoUAAAAYAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api\"\n" +
            "    },\n" +
            "    \"language\": \"en\",\n" +
            "    \"previewLink\": \"http://books.google.co.in/books?id=ACoUAAAAYAAJ&q=flowers+inauthor&dq=flowers+inauthor&hl=&cd=10&source=gbs_api\",\n" +
            "    \"infoLink\": \"http://books.google.co.in/books?id=ACoUAAAAYAAJ&dq=flowers+inauthor&hl=&source=gbs_api\",\n" +
            "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/The_Register_of_the_Kentucky_Historical.html?hl=&id=ACoUAAAAYAAJ\"\n" +
            "   },\n" +
            "   \"saleInfo\": {\n" +
            "    \"country\": \"IN\",\n" +
            "    \"saleability\": \"NOT_FOR_SALE\",\n" +
            "    \"isEbook\": false\n" +
            "   },\n" +
            "   \"accessInfo\": {\n" +
            "    \"country\": \"IN\",\n" +
            "    \"viewability\": \"NO_PAGES\",\n" +
            "    \"embeddable\": false,\n" +
            "    \"publicDomain\": false,\n" +
            "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "    \"epub\": {\n" +
            "     \"isAvailable\": false\n" +
            "    },\n" +
            "    \"pdf\": {\n" +
            "     \"isAvailable\": false\n" +
            "    },\n" +
            "    \"webReaderLink\": \"http://play.google.com/books/reader?id=ACoUAAAAYAAJ&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "    \"accessViewStatus\": \"NONE\",\n" +
            "    \"quoteSharingAllowed\": false\n" +
            "   },\n" +
            "   \"searchInfo\": {\n" +
            "    \"textSnippet\": \"As a boy, Ruston \\u003cb\\u003eFlowers\\u003c/b\\u003e of Logan County enjoyed such nights and recalls that \\u003cbr\\u003e\\nhe &quot;used to take potatoes and put them in the ... &quot;Eunice McCarty interview, 9 \\u003cbr\\u003e\\nMarch 1987, \\u003cb\\u003ein author&#39;s\\u003c/b\\u003e possession; Oatts interview; Thomas F. Hamilton \\u003cbr\\u003e\\ninterview,&nbsp;...\"\n" +
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

                BookList bookList = new BookList(null,title,author_name,preview_url,downloadAvailable,downloadOrViewUrl);
                bookLists.add(bookList);

            }

        } catch (JSONException e) {
            Log.e("QueryUtils", "Problem parsing the JSON results", e);
        }

        return bookLists;
    }
}
