package com.symphony.urlfaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final String IPHONE_USER_AGENT = "Mozilla/5.0 (iPhone; CPU iPhone OS 6_1_4 like Mac OS X) " +
            "AppleWebKit/536.26 (KHTML, like Gecko) Version/6.0 Mobile/10B350 Safari/8536.25";

    private WebView mWebview;
    private Button mSubmit;
    private EditText mUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebview = (WebView)findViewById(R.id.webview);
        mSubmit = (Button)findViewById(R.id.submit);
        mUrl = (EditText)findViewById(R.id.url);

        WebSettings settings = mWebview.getSettings();
        settings.setUserAgentString(IPHONE_USER_AGENT);
        settings.setJavaScriptEnabled(true);
        mWebview.getSettings().setUserAgentString(IPHONE_USER_AGENT);
        String html = "<html><head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "    <link type=\"text/css\" href=\"app-1593eba156.css\" rel=\"stylesheet\">\n" +
                "    <link rel=\"icon\" href=\"favicon.ico?v=1.1\">\n" +
                "    <script type=\"text/javascript\" async=\"\" src=\"https://www.gstatic.com/recaptcha/api2/r20170202142949/recaptcha__en.js\"></script><script type=\"text/javascript\">\n" +
                "      var isIE11 = !!window.navigator.userAgent.match(/Trident.*rv[ :]*11\\./);\n" +
                "\n" +
                "      var chromeVer = -1;\n" +
                "      var chrome = window.navigator.userAgent.match(/(Chrome|CriOS)\\/(\\d+)\\./);\n" +
                "      if (chrome && chrome.length == 3) {\n" +
                "        chromeVer = parseInt(chrome[2],10);\n" +
                "      }\n" +
                "\n" +
                "      var ua = window.navigator.userAgent;\n" +
                "\n" +
                "      var iOS = /iphone/i.test(ua);\n" +
                "      var wp = /Windows Phone/i.test(ua);\n" +
                "      var android = /android/i.test(ua);\n" +
                "      var bb = /BlackBerry/i.test(ua);\n" +
                "      var bb10 = /BB10/i.test(ua);\n" +
                "\n" +
                "      var supportsWebWorker = (function() {\n" +
                "          //\n" +
                "          // to support inline images, web workers are used to decrypt images.\n" +
                "          // two key features are needed:\n" +
                "          // 1. webworkify creates worker using object url\n" +
                "          // 2. transferable support needed to move large file data between\n" +
                "          //    main thread to worker\n" +
                "          // older versions of IE do not support these features (e.g., 11.0.9600.17031).\n" +
                "          // it is known that IE ver 11.0.9600.18350 or higher does support\n" +
                "          // this feature set. in between versions of IE11 might supports these\n" +
                "          // features but it is not possible install and check.\n" +
                "          // also IE11 user agent does not give full vesion, so it is not\n" +
                "          // possible to use that method to filter out browsers,\n" +
                "          // so instead relying on feature detection below.\n" +
                "          //\n" +
                "          var worker;\n" +
                "          try {\n" +
                "              var URL = window.URL || window.webkitURL || window.mozURL || window.msURL;\n" +
                "              var blob = new Blob([], { type: 'text/javascript' });\n" +
                "              var workerUrl = URL.createObjectURL(blob);\n" +
                "              worker = new Worker(workerUrl);\n" +
                "          } catch(e) {\n" +
                "              return false;\n" +
                "          }\n" +
                "\n" +
                "          var ab = new ArrayBuffer(1);\n" +
                "          try {\n" +
                "              worker.postMessage(ab, [ab]);\n" +
                "              if (ab.byteLength) {\n" +
                "                  return false;\n" +
                "              } else {\n" +
                "                  return true;\n" +
                "              }\n" +
                "            } catch(e) {\n" +
                "                return false;\n" +
                "            }\n" +
                "      }());\n" +
                "\n" +
                "      // safari on osx\n" +
                "      var safariMajorVersion = -1;\n" +
                "      var safariUA = window.navigator.userAgent.match(/Version\\/(\\d+)(?:\\.\\d+)* Safari/);\n" +
                "      if (safariUA && safariUA.length == 2) {\n" +
                "          safariMajorVersion = parseInt(safariUA[1], 10);\n" +
                "      }\n" +
                "\n" +
                "      if (wp || bb || bb10) {\n" +
                "          window.location = \"./mobile.html\"\n" +
                "      }\n" +
                "\n" +
                "      var chrome32 = (chromeVer >= 32);\n" +
                "      var safari8 = (safariMajorVersion >= 8);\n" +
                "\n" +
                "      // desktop client browsers must support web worker features\n" +
                "      if (!supportsWebWorker && (isIE11 || chrome32 || safari8)) {\n" +
                "          window.location = \"./browsers.html\"\n" +
                "      }\n" +
                "\n" +
                "      if (!(isIE11 || chrome32 || iOS || wp || bb || bb10 || safari8)) {\n" +
                "        window.location = \"./browsers.html\"\n" +
                "      }\n" +
                "\n" +
                "      window.env = {\n" +
                "          LOGIN_URL: '/login',\n" +
                "          PUBLIC_POD: true,\n" +
                "          iOS: iOS,\n" +
                "          android: android,\n" +
                "          MOBILE_SUPPORTED: true,\n" +
                "          // This app id is also hardcoded into the iOs landing page \"iOS.html\"\n" +
                "          iOSAppId: 1098963705\n" +
                "      };\n" +
                "\n" +
                "      window.captchaDidLoad = function() {\n" +
                "        window.captchaLoaded = true;\n" +
                "        $(document).trigger('captchaDidLoad');\n" +
                "      };\n" +
                "    </script>\n" +
                "    <script src=\"https://www.google.com/recaptcha/api.js?onload=captchaDidLoad&amp;render=explicit\" async=\"\" defer=\"\"></script>\n" +
                "    <script src=\"app-c3b9ba0fef.js\"></script>\n" +
                "    <title>Symphony | Secure Seamless Communication</title>\n" +
                "  <meta name=\"apple-itunes-app\" content=\"app-id=1098963705, app-argument=symphony://emailVerification?pod=qa8.symphony.com&amp;evt=eyJhbGciOiJSUzI1NiJ9.eyJpZCI6NzgzNDAyMDM1NTQyOSwiZXhwIjoxNDY5ODEzODgyLCJlbWFpbCI6ImRjaGFuLnN5bXBob255K2Vhcmd0YWVyQGdtYWlsLmNvbSJ9.SwYEo51uSl67iR0JTFwcTIG-UoYLjqPwRSneRLNK5agmOypVTERIqe39O-fRH5YkATFZ4CzTKq-jLgsxvBOOPACKFnLEemKqu5LfGfsWcKA-BfTEl7uhcaT1V69Jlg1cz98Uid4jNpnTJePH3_6ygrtbwRgD1w5HEH1KqjZLtH0\"></head>\n" +
                "  <body>\n" +
                "    <header>\n" +
                "      <div id=\"logo\"></div>\n" +
                "    </header>\n" +
                "  \n" +
                "\n" +
                "<div id=\"sysMsg\"></div><div id=\"authentication\"><div class=\"mobile\"><div class=\"mobile-prompt\">\n" +
                "    <h1 class=\"mobile-prompt__header\">Secure, seamless communication</h1>\n" +
                "    <p class=\"mobile-prompt__text\">Robust messaging and productivity for all your business communication needs.</p>\n" +
                "    <div class=\"mobile-prompt__buttons\">\n" +
                "        <a href=\"symphony://chat_with?username=john.smith&name=John%20Smith\" id=\"symphony-app\" class=\"button\">LAUNCH THE APP</a>\n" +
                "        <br>\n" +
                "        \n" +
                "            <a href=\"itmss://itunes.apple.com/us/app/symphony.com-secure-messaging/id1098963705?ls=1&amp;mt=8\" class=\"button\">\n" +
                "                DOWNLOAD\n" +
                "            </a>\n" +
                "        \n" +
                "    </div>\n" +
                "</div></div></div></body></html>";
        String mime = "text/html";
        String encoding = "utf-8";

        mWebview.loadDataWithBaseURL(null, html, mime, encoding, null);


//        mSubmit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent("symphony://emailVerification=asdfasdfasd");
//                MainActivity.this.startActivity(i);
//                mWebview.loadUrl(mUrl.getText().toString());
//            }
//        });
    }
}
