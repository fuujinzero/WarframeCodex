package com.a20076520.skirmantas.warframecodex;

import android.content.Intent;
import android.view.MenuItem;

/**
 * Created by exnio_000 on 16/03/2018.
 */

public class Framelist extends Addframe {
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.action_addframes : startActivity(new Intent(this, Addframe.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
