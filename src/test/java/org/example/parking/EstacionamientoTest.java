package org.example.parking;

import org.junit.Test;
import org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EstacionamientoTest {

    @Test
    public void testRetirarVehiculo() throws Exception {
        //TODO test
        Estacionamiento estacionamiento = new Estacionamiento();
        Vehiculo vehiculo = new Vehiculo("AA111AA","2007", Vehiculo.Tipo.AUTO);
        estacionamiento.ingresarVehiculo("12345678","Martin",vehiculo);

        Ticket ticket = estacionamiento.retirarVehiculo("AA111AA");
        assertEquals("AA111AA",ticket.getVehiculo().getPatente());
        assertTrue(ticket.getHoraSalida() != null);
        assertEquals(0, estacionamiento.listarVehiculosEstacionados().size());

    }

    @Test
    public void testCalcularPrecio() throws Exception {
        // TODO test
        Cliente cliente = new Cliente("12345678","Martin");
        Vehiculo vehiculo = new Vehiculo("AA111AA","2007", Vehiculo.Tipo.AUTO);
        Ticket ticket = new Ticket(cliente, vehiculo);
        ticket.setHoraSalida(ticket.getHoraEntrada().plusMinutes(60));

        double tarifa = ticket.calcularPrecio();
        assertEquals(100,tarifa);

    }

}