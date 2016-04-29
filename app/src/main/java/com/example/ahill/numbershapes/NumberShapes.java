package com.example.ahill.numbershapes;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class NumberShapes extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    /**
     * Checks to see if a number entered by the user is a triangular or square number.
     *
     * @param view
     */
    public void checkShape(View view) {
        // get the user input
        EditText userText = (EditText) findViewById(R.id.userInput);

        // check to ensure the actually entered a number
        if (isNullOrEmpty(userText)) {
            // if they didn't then exit the function and let them know to enter a number
            displayMessage("Please enter a number greater than zero");
            return;
        }

        // get the number the user entered
        int userNumber = Integer.parseInt(userText.getText().toString());

        // check to ensure we are not getting a negative number, which are neither triangular or square
        if (userNumber < 0) {
            // let the user know to enter a non-negative number and exit
            displayMessage("Please enter a number greater than zero");
            return;
        }

        // check to see if the number is triangular or square
        boolean isTriangular = isTriangular(userNumber);
        boolean isSquare = isPerfectSquare(userNumber);

        // display the appropriate message to the user
        if (isSquare && isTriangular) {
            displayMessage("The number is both a square and triangular number");
        } else if (isTriangular) {
            displayMessage("The number is triangular");
        } else if (isSquare) {
            displayMessage("The number is a square number");
        } else {
            displayMessage("The number is not triangular or square");
        }
    }

    /**
     * Checks to see if the provided {@link EditText} is null or empty.
     *
     * @param text
     * @return {@code true} if the text is null or empty, {@code false} otherwise
     */
    private boolean isNullOrEmpty(EditText text) {
        return text == null || // check if the EditText is null
                text.getText() == null || // check if the text within the object is null
                text.getText().toString().equals(""); // finally, check to see if the text is empty
    }

    /**
     * Displays a message to the user as a {@link Toast}
     *
     * @param message
     */
    private void displayMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    /**
     * Checks to see if a given number is triangular or not
     * @param numberToCheck
     * @return
     */
    private boolean isTriangular(int numberToCheck) {
        // a triangular number is found in the formula ( n (n + 1) ) / 2,
        // if we set the triangular number equal the above formula, we get:
        // 8T + 1 = (2n + 1)^2,
        // so a triangular number is one where 8T + 1 is odd and a perfect square
        int value = 8 * numberToCheck + 1;

        Log.i("Info", "value = " + value);

        // check for the value to be odd
        return value % 2 != 0 && isPerfectSquare(value);
    }

    /**
     * Checks to see if the given number is a perfect square.
     *
     * @param numberToCheck
     * @return
     */
    private boolean isPerfectSquare(int numberToCheck) {
        // perform the square root of the number
        double squareRoot = Math.sqrt((double) numberToCheck);

        Log.i("Info", "square root = " + squareRoot);

        // get any remainder after the decimal point in the square root value, and check to see
        // if it is equal to 0, a zero value indicates a perfect square
        return (squareRoot - Math.floor(squareRoot)) == 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_shapes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_number_shapes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "NumberShapes Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.ahill.numbershapes/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "NumberShapes Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.ahill.numbershapes/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
