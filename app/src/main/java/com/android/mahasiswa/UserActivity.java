package com.android.mahasiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.android.mahasiswa.databinding.ActivityUserBinding;

public class UserActivity extends AppCompatActivity {

   ActivityUserBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();

        if (intent != null){

            String nama = intent.getStringExtra("nama");
            String nim = intent.getStringExtra("nim");
            String email = intent.getStringExtra("email");
            String angkatan = intent.getStringExtra("angkatan");
            String fakultas = intent.getStringExtra("fakultas");
            String prodi = intent.getStringExtra("prodi");
            String semester = intent.getStringExtra("semester");
            String status = intent.getStringExtra("status");
            int imageid = intent.getIntExtra("imageid",R.drawable.pic2);

            binding.nameProfile.setText(nama);
            binding.nimProfile.setText(nim);
            binding.emailProfile.setText(email);
            binding.angkatanProfile.setText(angkatan);
            binding.fakultasProfile.setText(fakultas);
            binding.prodiProfile.setText(prodi);
            binding.semesterProfile.setText(semester);
            binding.statusProfile.setText(status);
            binding.profileImage.setImageResource(imageid);


        }

    }
}