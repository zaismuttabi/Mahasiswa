package com.android.mahasiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.android.mahasiswa.databinding.ActivityMahasiswaBinding;

import java.util.ArrayList;

public class MahasiswaActivity extends AppCompatActivity {

    ActivityMahasiswaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMahasiswaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageId = {R.drawable.pic2,R.drawable.person_110935,R.drawable.person_110935,R.drawable.person_110935,R.drawable.person_110935,
                R.drawable.pic1,R.drawable.person_110935,R.drawable.person_110935,R.drawable.person_110935};
        String[] nama = {"Zaisul Muttabi","Nurul","Fikri Alawi","Widya Tri","Ramdhan Hidayatullah","Mirza Akrom","Toa","Ivana","Alex"};
        String[] nim = {"19101140252","191011402706","191011402701","191011402730","191011402707",
                "191011402797","191011402720","191011402732","191011402729"};
        String[] email = {"zaismuttabi@gmail.com","nurulcessy@gmail.com","fikrimuhammad@gmail.com","htadashi520@gmail.com","muhammadramdhan@gmail.com",
                "mirzaakrom@gmail.com","7:34 pm","2:32 am","7:76 am"};
        String[] angkatan = {"2019","2019","2019","2019","2019",
                "2019","2019","2019","2019"};
        String[] fakultas = {"Teknik","Teknik","Teknik","Teknik","Teknik","Teknik","Teknik","Teknik","Teknik"};
        String[] prodi = {"Teknik Informatika","Teknik Informatika","Teknik Informatika","Teknik Informatika","Teknik Informatika","Teknik Informatika","Teknik Informatika","Teknik Informatika","Teknik Informatika"};
        String[] semester = {"1","1","1","1","1","1","1","1","1","1"};
        String[] status = {"Aktif","Aktif","Aktif","Aktif","Aktif","Aktif","Aktif","Aktif","Aktif","Aktif"};


        ArrayList<User> userArrayList = new ArrayList<>();

        for(int i = 0;i< imageId.length;i++){

            User user = new User(nama[i],nim[i],email[i],angkatan[i],fakultas[i],prodi[i],semester[i],status[i],imageId[i]);
            userArrayList.add(user);

        }


        ListAdapter listAdapter = new ListAdapter(MahasiswaActivity.this,userArrayList);

        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(MahasiswaActivity.this,UserActivity.class);
                i.putExtra("nama",nama[position]);
                i.putExtra("nim",nim[position]);
                i.putExtra("email",email[position]);
                i.putExtra("angkatan",angkatan[position]);
                i.putExtra("fakultas",fakultas[position]);
                i.putExtra("prodi",prodi[position]);
                i.putExtra("semester",semester[position]);
                i.putExtra("status",status[position]);
                i.putExtra("imageid",imageId[position]);
                startActivity(i);

            }
        });

    }
}