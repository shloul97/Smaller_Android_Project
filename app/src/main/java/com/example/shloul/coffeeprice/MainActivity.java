package com.example.shloul.coffeeprice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int quantity = 2;
    int duration = Toast.LENGTH_LONG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setBackgroundDrawableResource(R.drawable.coffee4);


    }
    public void submitOrder(View view) {

        displayQuantity(quantity);
        displayMessage(creatOrderSummary());
        /** Intent intent = new Intent(Intent.ACTION_SEND);

         intent.putExtra(Intent.EXTRA_SUBJECT, "Order Received");
         intent.putExtra(Intent.EXTRA_TEXT,creatOrderSummary());
         if (intent.resolveActivity(getPackageManager()) != null) {
         startActivity(intent);
         }*/



    }

    // To view number of quantity in quantity TextView
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.picetxt);
        quantityTextView.setText("" + number);

    }
    //calculate the price of quantity
    private int calculatePrice()
    {
        int price = quantity *5;
        boolean adds;
        boolean adds1;

        CheckBox whippedCream =  findViewById(R.id.whippedCream_checkBox);
        CheckBox chocolate =  findViewById(R.id.choclate_checkBox);
        adds = whippedCream.isChecked();
        adds1 = chocolate.isChecked();
        if(adds == true)
        {

            for (int i = 0; i<quantity;i++)
            {
                price++;
            }
        }
        if(adds1 == true)
        {
            for (int i = 0; i<quantity;i++)
            {
                price+=2;
            }

        }
        return price;

    }
    //Increase quantity by 1
    public void  increment(View number)
    {
        if(quantity ==100)
        {
            Toast.makeText(this, "You can't have more 100 cups of coffee",duration).show();
            return;
        }
        quantity++;
        displayQuantity(quantity);
    }
    //Decrease of quantity by 1
    public void decrement(View number)
    {
        if(quantity==1)
        {
            Toast.makeText(this, "You can't have less 1 cups of coffee",duration).show();
            return;
        }
        quantity--;
        displayQuantity(quantity);
    }
    //View Summary in TextView
    private String creatOrderSummary()
    {
        Editable name = displayName();
        String message = getString(R.string.thankYou);
        String s = name + "\n" + getString(R.string.quantity_text)+" : " + quantity +"\n"+
                getString(R.string.total_text)+" : " + (NumberFormat.getCurrencyInstance()
                .format(calculatePrice()))+"\n"+ checkBox() + "\n" + message ;
        return s;
    }
    private  void displayMessage(String message)
    {
        TextView orderSummaryTextView =  findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
        orderSummaryTextView.setGravity(Gravity.LEFT);

    }
    private Editable displayName()
    {
        EditText nameInput =  findViewById(R.id.editText);
        Editable name = nameInput.getText();
        return name;
    }
    private String checkBox()
    {
        boolean adds;
        boolean adds1;
        String message = "";
        CheckBox whippedCream =  findViewById(R.id.whippedCream_checkBox);
        CheckBox choclate =  findViewById(R.id.choclate_checkBox);
        adds = whippedCream.isChecked();
        adds1 = choclate.isChecked();
        if(adds == true)
        {
            message = getString(R.string.topping1);
        }
        if(adds1 == true)
        {
            message += "\n" + getString(R.string.topping2);
        }
        return message;
    }
    public void  btn1(View view)
    {

    }
    public void  btn2(View view)
    {

    }
}
