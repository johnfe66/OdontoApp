package com.johnfe.odontoapp;

import android.app.DatePickerDialog;
import android.app.Dialog;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class RegistroPacienteActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private Button btnBuscarCC;
    private Button btnFecNac;
    private Button btnFecIng;
    private EditText txtCCBuscar;
    private Button btnRegistrarHistoria;
    private Paciente paciente;
    private CitaPaciente citaPaciente;

    private EditText  txtFecha;

    private EditText txtCedula;
    private EditText txtNombre;
    private EditText txtFecNac;
    private EditText txtEdad;
    private EditText txtEstadoCivil;
    private EditText txtGenero;
    private EditText txtDepartamento;
    private EditText txtMunicipio;
    private EditText txtDireccion;
    private EditText txtNacionalidad;
    private EditText txtVinculacion;
    private EditText txtFechaIngreso;
    private EditText txtTelFijo;
    private EditText txtTelOficina;
    private EditText txtTelCelular;
    private EditText txtEmailPaciente;
    private EditText txtOcupacion;
    private EditText txtEps;
    private EditText txtHabitos;
    private EditText txtAlergias;
    private EditText txtAntecedentes;
    private EditText txtRevisionSistemas;
    private EditText txtMedicamentosUso;
    private EditText txtEnfermedadActual;


    private EditText txtMotivoConsulta;
    private EditText txtAcudiente;
    private EditText txtCedulaAcudiente;
    private EditText txtTelefonoAcudiente;
    private EditText txtParentesco;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_paciente);


        btnRegistrarHistoria = (Button) findViewById(R.id.btnContinuar);

        btnFecNac = (Button) findViewById(R.id.btnFecNac);
        btnFecIng = (Button) findViewById(R.id.btnFecIng);
        btnBuscarCC = (Button) findViewById(R.id.btnBuscarCC);
        txtCCBuscar = (EditText) findViewById(R.id.txtCCBuscar);
        txtCedula = (EditText) findViewById(R.id.txtCedula);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtFecNac = (EditText) findViewById(R.id.txtFecNac);

        txtEdad = (EditText) findViewById(R.id.txtEdad);
        txtEstadoCivil = (EditText) findViewById(R.id.txtEstadoCivil);
        txtGenero = (EditText) findViewById(R.id.txtGenero);
        txtDepartamento = (EditText) findViewById(R.id.txtDepartamento);
        txtDireccion = (EditText) findViewById(R.id.txtDireccion);
        txtNacionalidad = (EditText) findViewById(R.id.txtNacionalidad);
        txtVinculacion = (EditText) findViewById(R.id.txtVinculacion);
        txtFechaIngreso = (EditText) findViewById(R.id.txtFechaIngreso);
        txtTelFijo = (EditText) findViewById(R.id.txtTelFijo);
        txtTelOficina = (EditText) findViewById(R.id.txtTelOficina);
        txtTelCelular = (EditText) findViewById(R.id.txtTelCelular);
        txtEmailPaciente = (EditText) findViewById(R.id.txtEmailPaciente);
        txtOcupacion = (EditText) findViewById(R.id.txtOcupacion);
        txtEps = (EditText) findViewById(R.id.txtEps);
        txtHabitos = (EditText) findViewById(R.id.txtHabitos);
        txtAlergias = (EditText) findViewById(R.id.txtAlergias);
        txtAntecedentes = (EditText) findViewById(R.id.txtAntecedentes);
        txtRevisionSistemas = (EditText) findViewById(R.id.txtRevisionSistemas);
        txtMedicamentosUso = (EditText) findViewById(R.id.txtMedicamentosUso);
        txtAlergias = (EditText) findViewById(R.id.txtAlergias);
        txtAntecedentes = (EditText) findViewById(R.id.txtAntecedentes);
        txtAcudiente = (EditText) findViewById(R.id.txtAcudiente);
        txtEnfermedadActual = (EditText) findViewById(R.id.txtEnfermedadActual);
        txtMotivoConsulta = (EditText) findViewById(R.id.txtMotivoConsulta);
        txtCedulaAcudiente = (EditText) findViewById(R.id.txtCedulaAcudiente);
        txtTelefonoAcudiente = (EditText) findViewById(R.id.txtTelefonoAcudiente);
        txtParentesco = (EditText) findViewById(R.id.txtParentesco);
        txtMunicipio = (EditText) findViewById(R.id.txtMunicipio);

        btnBuscarCC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference pacienteRefCC = database.getReference("pacientes");

                pacienteRefCC.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        if (dataSnapshot.hasChild(txtCCBuscar.getText().toString().trim())) {
                            dataSnapshot.child(txtCCBuscar.getText().toString().trim());
                            Toast.makeText(getApplicationContext(), "Si existe paciente ",
                                    Toast.LENGTH_SHORT).show();

                            paciente = dataSnapshot.child(txtCCBuscar.getText().toString().trim()).getValue(Paciente.class);

                            txtCedula.setText(paciente.getCedula());
                            txtDireccion.setText(paciente.getDireccion());
                            txtEdad.setText(paciente.getEdad());
                            txtDepartamento.setText(paciente.getDepartamento());
                            txtAlergias.setText(paciente.getAlergias());
                            txtAntecedentes.setText(paciente.getAntecedentes());
                            txtEmailPaciente.setText(paciente.getEmail());
                            txtNombre.setText(paciente.getNombre());
                            txtFecNac.setText(paciente.getFechaNacimiento());
                            txtEstadoCivil.setText(paciente.getEstadoCivil());
                            txtGenero.setText(paciente.getGenero());
                            txtMunicipio.setText(paciente.getMunicipio());
                            txtNacionalidad.setText(paciente.getNacionalidad());
                            txtVinculacion.setText(paciente.getVinculacion());
                            txtFechaIngreso.setText(paciente.getFechaIngreso());
                            txtTelFijo.setText(paciente.getTelefonoFijo());
                            txtTelOficina.setText(paciente.getTelefonoOficina());
                            txtTelCelular.setText(paciente.getTelefonoCelular());
                            txtOcupacion.setText(paciente.getOcupacion());
                            txtEps.setText(paciente.getEps());
                            txtHabitos.setText(paciente.getHabitos());
                            txtRevisionSistemas.setText(paciente.getRevisionSistemas());
                            txtMedicamentosUso.setText(paciente.getMedicamentosEnUso());
                            txtEnfermedadActual.setText(paciente.getHistoriaEnfermedadActual());


                            for (DataSnapshot data : dataSnapshot.child(txtCCBuscar.getText().toString().trim()).child("historiaOdontologica").getChildren()) {

                                System.out.println("cedula acu--" + data.child("cedulaAcudiente").getValue(String.class));
                                for (DataSnapshot dataDiente : data.child("diagnosticoDientes").getChildren()
                                        ) {

                                    System.out.println(dataDiente.child("numeroDiente").getValue(Long.class));

                                }
                            }

                        } else {

                            Toast.makeText(getApplicationContext(), "No existe paciente",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.


                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        System.out.println("Failed to read value." + error.toException());
                    }
                });
            }
        });
        btnRegistrarHistoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                paciente = new Paciente();
                insertarPaciente(paciente);
                citaPaciente = new CitaPaciente();
                insertarHistoria(citaPaciente);


            }
        });

        btnFecNac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                txtFecha= (EditText) txtFecNac.findViewById(R.id.txtFecNac);

                datePicker(view);
            }
        });

        btnFecIng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                txtFecha= (EditText) txtFechaIngreso.findViewById(R.id.txtFechaIngreso);

                datePicker(view);
            }
        });

    }

    public void insertarHistoria(CitaPaciente citaPaciente) {

        citaPaciente.setCedulaPaciente(txtCedula.getText().toString().trim());
        citaPaciente.setCedulaAcudiente(txtCedulaAcudiente.getText().toString().trim());
        citaPaciente.setFechaCita(new Date().toString());
        citaPaciente.setMotivoConsulta(txtMotivoConsulta.getText().toString().trim());
        citaPaciente.setNombreAcudiente(txtAcudiente.getText().toString().trim());
        citaPaciente.setTelfonoAcudiente(txtTelefonoAcudiente.getText().toString().trim());
        citaPaciente.setParentescoAcudiente(txtParentesco.getText().toString().trim());

        Intent intent = new Intent(RegistroPacienteActivity.this, MapDentalActivity.class);
        Bundle bundle = new Bundle();

        bundle.putString("cedulaPaciente", citaPaciente.getCedulaPaciente());
        bundle.putString("cedulaAcudiente", citaPaciente.getCedulaAcudiente());
        bundle.putString("fechaCita", citaPaciente.getFechaCita());
        bundle.putString("motivoConsulta", citaPaciente.getMotivoConsulta());
        bundle.putString("nombreAcudiente", citaPaciente.getNombreAcudiente());
        bundle.putString("TelefonoAcudiente", citaPaciente.getTelfonoAcudiente());
        bundle.putString("parentescoAcudiente", citaPaciente.getParentescoAcudiente());

        intent.putExtras(bundle);
        startActivity(intent);

    }

    public void insertarPaciente(Paciente paciente) {

        paciente.setCedula(txtCedula.getText().toString().trim());
        paciente.setDireccion(txtDireccion.getText().toString().trim());
        paciente.setEdad(txtEdad.getText().toString().trim());
        paciente.setDepartamento(txtDepartamento.getText().toString().trim());

        paciente.setAlergias(txtAlergias.getText().toString().trim());
        paciente.setAntecedentes(txtAntecedentes.getText().toString().trim());

        paciente.setEmail(txtEmailPaciente.getText().toString().trim());
        paciente.setNombre(txtNombre.getText().toString().trim());
        paciente.setFechaNacimiento(txtFecNac.getText().toString().trim());
        paciente.setEstadoCivil(txtEstadoCivil.getText().toString().trim());
        paciente.setGenero(txtGenero.getText().toString().trim());
        paciente.setMunicipio(txtMunicipio.getText().toString().trim());
        paciente.setNacionalidad(txtNacionalidad.getText().toString().trim());
        paciente.setVinculacion(txtVinculacion.getText().toString().trim());
        paciente.setFechaIngreso(txtFechaIngreso.getText().toString().trim());
        paciente.setTelefonoFijo(txtTelFijo.getText().toString().trim());
        paciente.setTelefonoOficina(txtTelOficina.getText().toString().trim());
        paciente.setTelefonoCelular(txtTelCelular.getText().toString().trim());
        paciente.setOcupacion(txtOcupacion.getText().toString().trim());
        paciente.setEps(txtEps.getText().toString().trim());
        paciente.setHabitos(txtHabitos.getText().toString().trim());
        paciente.setRevisionSistemas(txtRevisionSistemas.getText().toString().trim());
        paciente.setMedicamentosEnUso(txtMedicamentosUso.getText().toString().trim());
        paciente.setHistoriaEnfermedadActual(txtEnfermedadActual.getText().toString().trim());


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference pacientesRef = database.getReference("pacientes").child(paciente.getCedula().trim());
        pacientesRef.setValue(paciente);
        System.out.println("Registro de paciente exitoso");

    }

    public void datePicker(View view) {

        System.out.println("id view datepicker-----"+view.getId());
        DatePickerFragment fragment = new DatePickerFragment();
        fragment.show(getSupportFragmentManager(), "Fecha");
    }

    public void setDate(final Calendar calendar) {

        final DateFormat dateFormat= DateFormat.getDateInstance().getDateInstance(DateFormat.LONG);
        txtFecha.setText(dateFormat.format(calendar.getTime()));



    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        Calendar calendar = new GregorianCalendar(year,month,day);

        setDate(calendar);

    }

    public static class DatePickerFragment extends android.support.v4.app.DialogFragment{

        @Override
        public Dialog onCreateDialog(Bundle saveInstanceState){
            final Calendar c = Calendar.getInstance();
            int year= c.get(Calendar.YEAR);
            int month= c.get(Calendar.MONTH);
            int day= c.get(Calendar.DAY_OF_MONTH);

            return  new DatePickerDialog(getActivity(),(DatePickerDialog.OnDateSetListener) getActivity(),year,month,day);

        }
    }
}
