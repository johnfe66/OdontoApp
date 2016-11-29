package com.johnfe.odontoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MapDentalActivity extends AppCompatActivity {

    ImageButton ib11;
    ImageButton ib12;
    ImageButton ib13;
    ImageButton ib14;
    ImageButton ib15;
    ImageButton ib16;
    ImageButton ib17;
    ImageButton ib18;
    ImageButton ib21;
    ImageButton ib22;
    ImageButton ib23;
    ImageButton ib24;
    ImageButton ib25;
    ImageButton ib26;
    ImageButton ib27;
    ImageButton ib28;
    ImageButton ib31;
    ImageButton ib32;
    ImageButton ib33;
    ImageButton ib34;
    ImageButton ib35;
    ImageButton ib36;
    ImageButton ib37;
    ImageButton ib38;
    ImageButton ib41;
    ImageButton ib42;
    ImageButton ib43;
    ImageButton ib44;
    ImageButton ib45;
    ImageButton ib46;
    ImageButton ib47;
    ImageButton ib48;

    CitaPaciente citaPaciente;
    Diente dienteObj;
    List<Diente> dienteList;
    Button btnTerminarCita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_dental);

        Bundle bundle = getIntent().getExtras();

        dienteList = new ArrayList<>();
        citaPaciente = new CitaPaciente();

        citaPaciente.setCedulaPaciente(bundle.getString("cedulaPaciente"));
        citaPaciente.setCedulaAcudiente(bundle.getString("cedulaAcudiente"));
        citaPaciente.setTelfonoAcudiente(bundle.getString("TelefonoAcudiente"));
        citaPaciente.setNombreAcudiente(bundle.getString("nombreAcudiente"));
        citaPaciente.setMotivoConsulta(bundle.getString("motivoConsulta"));
        citaPaciente.setParentescoAcudiente(bundle.getString("parentescoAcudiente"));
        citaPaciente.setFechaCita(bundle.getString("fechaCita"));

        btnTerminarCita = (Button) findViewById(R.id.btnTerminarMapaDental);
        ib11 = (ImageButton) findViewById(R.id.ib11);
        ib12 = (ImageButton) findViewById(R.id.ib12);
        ib13 = (ImageButton) findViewById(R.id.ib13);
        ib14 = (ImageButton) findViewById(R.id.ib14);
        ib15 = (ImageButton) findViewById(R.id.ib15);
        ib16 = (ImageButton) findViewById(R.id.ib16);
        ib17 = (ImageButton) findViewById(R.id.ib17);
        ib18 = (ImageButton) findViewById(R.id.ib18);

        ib21 = (ImageButton) findViewById(R.id.ib21);
        ib22 = (ImageButton) findViewById(R.id.ib22);
        ib23 = (ImageButton) findViewById(R.id.ib23);
        ib24 = (ImageButton) findViewById(R.id.ib24);
        ib25 = (ImageButton) findViewById(R.id.ib25);
        ib26 = (ImageButton) findViewById(R.id.ib26);
        ib27 = (ImageButton) findViewById(R.id.ib27);
        ib28 = (ImageButton) findViewById(R.id.ib28);

        ib31 = (ImageButton) findViewById(R.id.ib31);
        ib32 = (ImageButton) findViewById(R.id.ib32);
        ib33 = (ImageButton) findViewById(R.id.ib33);
        ib34 = (ImageButton) findViewById(R.id.ib34);
        ib35 = (ImageButton) findViewById(R.id.ib35);
        ib36 = (ImageButton) findViewById(R.id.ib36);
        ib37 = (ImageButton) findViewById(R.id.ib37);
        ib38 = (ImageButton) findViewById(R.id.ib38);

        ib41 = (ImageButton) findViewById(R.id.ib41);
        ib42 = (ImageButton) findViewById(R.id.ib42);
        ib43 = (ImageButton) findViewById(R.id.ib43);
        ib44 = (ImageButton) findViewById(R.id.ib44);
        ib45 = (ImageButton) findViewById(R.id.ib45);
        ib46 = (ImageButton) findViewById(R.id.ib46);
        ib47 = (ImageButton) findViewById(R.id.ib47);
        ib48 = (ImageButton) findViewById(R.id.ib48);

        ib11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dienteObj = new Diente();
                dienteObj = new Diente();
                dienteObj.setNumeroDiente(11);
                registerForContextMenu(ib11);
                openContextMenu(view);
            }
        });
        ib12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dienteObj = new Diente();
                dienteObj = new Diente();
                dienteObj.setNumeroDiente(12);
                registerForContextMenu(ib12);
                openContextMenu(view);
            }
        });
        ib13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dienteObj = new Diente();
                dienteObj.setNumeroDiente(13);
                registerForContextMenu(ib13);
                openContextMenu(view);
            }
        });
        ib14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dienteObj = new Diente();
                dienteObj.setNumeroDiente(14);
                registerForContextMenu(ib14);
                openContextMenu(view);
            }
        });
        ib15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dienteObj = new Diente();
                dienteObj.setNumeroDiente(15);
                registerForContextMenu(ib15);
                openContextMenu(view);
            }
        });
        ib16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dienteObj = new Diente();
                dienteObj.setNumeroDiente(16);
                registerForContextMenu(ib16);
                openContextMenu(view);
            }
        });
        ib17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dienteObj = new Diente();
                dienteObj.setNumeroDiente(17);
                registerForContextMenu(ib17);
                openContextMenu(view);
            }
        });
        ib18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dienteObj = new Diente();
                dienteObj.setNumeroDiente(18);
                registerForContextMenu(ib18);
                openContextMenu(view);
            }
        });


        ib21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dienteObj = new Diente();
                dienteObj.setNumeroDiente(21);
                registerForContextMenu(ib21);
                openContextMenu(view);
            }
        });
        ib22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dienteObj = new Diente();
                dienteObj.setNumeroDiente(22);
                registerForContextMenu(ib22);
                openContextMenu(view);
            }
        });
        ib23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dienteObj = new Diente();
                dienteObj.setNumeroDiente(23);
                registerForContextMenu(ib23);
                openContextMenu(view);
            }
        });
        ib24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dienteObj = new Diente();
                dienteObj.setNumeroDiente(24);
                registerForContextMenu(ib24);
                openContextMenu(view);
            }
        });
        ib25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dienteObj = new Diente();
                dienteObj.setNumeroDiente(25);
                registerForContextMenu(ib25);
                openContextMenu(view);
            }
        });
        ib26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dienteObj = new Diente();
                dienteObj.setNumeroDiente(26);
                registerForContextMenu(ib26);
                openContextMenu(view);
            }
        });
        ib27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dienteObj = new Diente();
                dienteObj.setNumeroDiente(27);
                registerForContextMenu(ib27);
                openContextMenu(view);
            }
        });
        ib28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dienteObj = new Diente();
                dienteObj.setNumeroDiente(28);
                registerForContextMenu(ib28);
                openContextMenu(view);
            }
        });


        ib31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dienteObj = new Diente();
                dienteObj.setNumeroDiente(31);
                registerForContextMenu(ib31);
                openContextMenu(view);
            }
        });
        ib32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dienteObj = new Diente();
                dienteObj.setNumeroDiente(32);
                registerForContextMenu(ib32);
                openContextMenu(view);
            }
        });
        ib33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dienteObj = new Diente();
                dienteObj.setNumeroDiente(33);
                registerForContextMenu(ib33);
                openContextMenu(view);
            }
        });
        ib34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dienteObj = new Diente();
                dienteObj.setNumeroDiente(34);
                registerForContextMenu(ib34);
                openContextMenu(view);
            }
        });
        ib35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dienteObj = new Diente();
                dienteObj.setNumeroDiente(35);
                registerForContextMenu(ib35);
                openContextMenu(view);
            }
        });
        ib36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dienteObj = new Diente();
                dienteObj.setNumeroDiente(36);
                registerForContextMenu(ib36);
                openContextMenu(view);
            }
        });
        ib37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dienteObj = new Diente();
                dienteObj.setNumeroDiente(37);
                registerForContextMenu(ib37);
                openContextMenu(view);
            }
        });
        ib38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dienteObj = new Diente();
                dienteObj.setNumeroDiente(38);
                registerForContextMenu(ib38);
                openContextMenu(view);
            }
        });


        ib41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dienteObj = new Diente();
                dienteObj.setNumeroDiente(41);
                registerForContextMenu(ib41);
                openContextMenu(view);
            }
        });
        ib42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dienteObj = new Diente();
                dienteObj.setNumeroDiente(42);
                registerForContextMenu(ib42);
                openContextMenu(view);
            }
        });
        ib43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dienteObj = new Diente();
                dienteObj.setNumeroDiente(43);
                registerForContextMenu(ib43);
                openContextMenu(view);
            }
        });
        ib44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dienteObj = new Diente();
                dienteObj.setNumeroDiente(44);
                registerForContextMenu(ib44);
                openContextMenu(view);
            }
        });
        ib45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dienteObj = new Diente();
                dienteObj.setNumeroDiente(45);
                registerForContextMenu(ib45);
                openContextMenu(view);
            }
        });
        ib46.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dienteObj = new Diente();
                dienteObj.setNumeroDiente(46);
                registerForContextMenu(ib46);
                openContextMenu(view);
            }
        });
        ib47.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dienteObj = new Diente();
                dienteObj.setNumeroDiente(47);
                registerForContextMenu(ib47);
                openContextMenu(view);
            }
        });
        ib48.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dienteObj = new Diente();
                dienteObj.setNumeroDiente(48);
                registerForContextMenu(ib48);
                openContextMenu(view);
            }
        });

        btnTerminarCita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                citaPaciente.setDiagnosticoDientes(dienteList);
                System.out.println(citaPaciente.getDiagnosticoDientes().size() + "----");
                for (Diente diente : citaPaciente.getDiagnosticoDientes()) {
                    System.out.println(citaPaciente.getDiagnosticoDientes().indexOf(diente));
                    System.out.println(diente.getNumeroDiente());
                    System.out.println(diente.getDiagnostico());
                    System.out.println(diente.getTratamiento());

                }
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference pacientesRef2 = database.getReference("HistoriasOdontologicas").child(citaPaciente.getCedulaPaciente().trim()).push();
                pacientesRef2.setValue(citaPaciente);

                terminar();



            }
        });

    }

    public void terminar(){
        dienteList.clear();
        dienteObj=null;
        Intent intent= new Intent(MapDentalActivity.this,RegistroPacienteActivity.class);
        startActivity(intent);


    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);


        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu_dental, menu);


    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.nada_ausente:
                System.out.println(dienteList.size());

                if (dienteList.contains(dienteObj)) {
                    dienteList.remove(dienteObj);
                    dienteObj.setDiagnostico("ausente");
                    dienteObj.setTratamiento("nada");
                    dienteList.add(dienteObj);


                } else {
                    dienteObj.setDiagnostico("ausente");
                    dienteObj.setTratamiento("nada");
                    dienteList.add(dienteObj);

                }

                Toast.makeText(
                        MapDentalActivity.this
                        , "Agregado"
                        , Toast.LENGTH_SHORT)
                        .show();
                return true;

            case R.id.nadaSano:
                if (dienteList.contains(dienteObj)) {

                    dienteList.remove(dienteObj);
                    dienteObj.setDiagnostico("sano");
                    dienteObj.setTratamiento("nada");
                    dienteList.add(dienteObj);


                } else {
                    dienteObj.setDiagnostico("sano");
                    dienteObj.setTratamiento("nada");
                    dienteList.add(dienteObj);

                }

                Toast.makeText(
                        MapDentalActivity.this
                        , "Agregado"
                        , Toast.LENGTH_SHORT)
                        .show();
                return true;

            case R.id.placa_incisal:
                if (dienteList.contains(dienteObj)) {

                    dienteList.remove(dienteObj);
                    dienteObj.setDiagnostico("desgaste incisal");
                    dienteObj.setTratamiento("placa");
                    dienteList.add(dienteObj);


                } else {
                    dienteObj.setDiagnostico("desgaste incisal");
                    dienteObj.setTratamiento("placa");
                    dienteList.add(dienteObj);

                }

                Toast.makeText(
                        MapDentalActivity.this
                        , "Agregado"
                        , Toast.LENGTH_SHORT)
                        .show();
                return true;

            case R.id.placa_oclural:
                if (dienteList.contains(dienteObj)) {

                    dienteList.remove(dienteObj);
                    dienteObj.setDiagnostico("desgaste oclural");
                    dienteObj.setTratamiento("placa");
                    dienteList.add(dienteObj);


                } else {
                    dienteObj.setDiagnostico("desgaste oclural");
                    dienteObj.setTratamiento("placa");
                    dienteList.add(dienteObj);

                }

                Toast.makeText(
                        MapDentalActivity.this
                        , "Agregado"
                        , Toast.LENGTH_SHORT)
                        .show();
                return true;

            case R.id.resina_placa:
                if (dienteList.contains(dienteObj)) {

                    dienteList.remove(dienteObj);
                    dienteObj.setDiagnostico("fractura incisal");
                    dienteObj.setTratamiento("resina + placa");
                    dienteList.add(dienteObj);


                } else {
                    dienteObj.setDiagnostico("fractura incisal");
                    dienteObj.setTratamiento("resina + placa");
                    dienteList.add(dienteObj);

                }

                Toast.makeText(
                        MapDentalActivity.this
                        , "Agregado"
                        , Toast.LENGTH_SHORT)
                        .show();
                return true;

            case R.id.placa_infraccion:
                if (dienteList.contains(dienteObj)) {

                    dienteList.remove(dienteObj);
                    dienteObj.setDiagnostico("infraccion");
                    dienteObj.setTratamiento("placa");
                    dienteList.add(dienteObj);


                } else {
                    dienteObj.setDiagnostico("infraccion");
                    dienteObj.setTratamiento("placa");
                    dienteList.add(dienteObj);

                }

                Toast.makeText(
                        MapDentalActivity.this
                        , "Agregado"
                        , Toast.LENGTH_SHORT)
                        .show();
                return true;

            case R.id.corona_placa_medio:
                if (dienteList.contains(dienteObj)) {

                    dienteList.remove(dienteObj);
                    dienteObj.setDiagnostico("fractura tercio medio");
                    dienteObj.setTratamiento("corona + placa");
                    dienteList.add(dienteObj);


                } else {
                    dienteObj.setDiagnostico("fractura tercio medio");
                    dienteObj.setTratamiento("corona + placa");
                    dienteList.add(dienteObj);

                }

                Toast.makeText(
                        MapDentalActivity.this
                        , "Agregado"
                        , Toast.LENGTH_SHORT)
                        .show();
                return true;

            case R.id.corona_placa_cervical:
                if (dienteList.contains(dienteObj)) {

                    dienteList.remove(dienteObj);
                    dienteObj.setDiagnostico("fractura tercio cervical");
                    dienteObj.setTratamiento("corona + placa");
                    dienteList.add(dienteObj);


                } else {
                    dienteObj.setDiagnostico("fractura tercio cervical");
                    dienteObj.setTratamiento("corona + placa");
                    dienteList.add(dienteObj);

                }

                Toast.makeText(
                        MapDentalActivity.this
                        , "Agregado"
                        , Toast.LENGTH_SHORT)
                        .show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
