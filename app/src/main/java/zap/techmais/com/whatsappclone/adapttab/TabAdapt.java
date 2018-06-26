package zap.techmais.com.whatsappclone.adapttab;


import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import zap.techmais.com.whatsappclone.fragments.ContatosFragment;
import zap.techmais.com.whatsappclone.fragments.ConversasFragment;

public class TabAdapt extends FragmentStatePagerAdapter {

    private String[] menuTab = {"CONVERSAS","CONTATOS"};


    public TabAdapt(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = new Fragment();


        switch (position){

            case 0:
                fragment = new ConversasFragment();
                break;

            case 1:
                fragment = new ContatosFragment();
                break;

                default:
                    fragment = null;
        }//switch
        return fragment;

    }//getItem




    @Override
    public int getCount() {
        return menuTab.length;
    }



    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return menuTab[position];
    }


}//FP
