package edu.calvin.cs262.lab09client;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;
import java.io.InputStream;

/**
 * This activity reads data from the Monopoly RESTful web service.
 * <p/>
 * The code is based on this tutorial:
 * http://www.techrepublic.com/blog/software-engineer/calling-restful-services-from-your-android-app/
 *
 * @author kvlinden
 * @version Summer, 2015
 */
public class Main extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.my_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View arg0) {
        Button b = (Button) findViewById(R.id.my_button);
        b.setClickable(false);
        new LongRunningGetIO().execute();
    }

    /**
     * This inner class sends an HTTP requests to the Monopoly RESTful service API. It uses an
     * asynchronous task to take the slow I/O off the main interface thread.
     * <p/>
     * It uses 10.0.2.2 to access localhost, see
     * http://developer.android.com/tools/devices/emulator.html#networkaddresses
     * <p/>
     * It retains the deprecated classes in order to remain backwards compatible for Android 4, see
     * http://stackoverflow.com/questions/29150184/httpentity-is-deprecated-on-android-now-whats-the-alternative
     */
    private static String PEOPLE_URI = "http://10.0.2.2:9998/monopoly/players";

    private class LongRunningGetIO extends AsyncTask<Void, Void, String> {

        /**
         * This method extracts text from the HTTP response entity.
         *
         * @param entity: the table from HTTP
         * @return out: the text from the HTTP response
         * @throws IllegalStateException
         * @throws IOException
         */
        protected String getASCIIContentFromEntity(HttpEntity entity) throws IllegalStateException, IOException {
            InputStream in = entity.getContent();
            StringBuffer out = new StringBuffer();
            int n = 1;
            while (n > 0) {
                byte[] b = new byte[4096];
                n = in.read(b);
                if (n > 0) out.append(new String(b, 0, n));
            }
            return out.toString();
        }

        /**
         * This method issues the HTTP GET request.
         *
         * @param params parameters we're asking for?
         * @return returns text or the error
         */
        @Override
        protected String doInBackground(Void... params) {
            HttpClient httpClient = new DefaultHttpClient();
            HttpContext localContext = new BasicHttpContext();
            HttpGet httpGet = new HttpGet(PEOPLE_URI);
            String text;
            try {
                HttpResponse response = httpClient.execute(httpGet, localContext);
                HttpEntity entity = response.getEntity();
                text = getASCIIContentFromEntity(entity);
            } catch (Exception e) {
                return e.getLocalizedMessage();
            }
            return text;
        }

        /**
         * The method takes the results of the request, when they arrive, and updates the interface.
         *
         * @param results the text received to be put on the text view.
         */
        protected void onPostExecute(String results) {
            if (results != null) {
                EditText et = (EditText) findViewById(R.id.my_edit);
                et.setText(results);
            }
            Button b = (Button) findViewById(R.id.my_button);
            b.setClickable(true);
        }

    }

}
