package jp.hokari.shunsuke.gymnasticsnavi.ui

import android.os.Bundle
import android.support.v7.app.ActionBarActivity
import jp.hokari.shunsuke.gymnasticsnavi.R

class MainActivity : ActionBarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.menu_main, menu)
//        return true
//    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        val id = item.itemId
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true
//        }
//
//        return super.onOptionsItemSelected(item)
//    }
}