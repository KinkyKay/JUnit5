package patientintake;

import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class ClinicCalendarShould {
   // always begin the test with the ampersand notation (@) //
   @Test
   void allowEntryOfAnAppointment() {
      // SETUP / Creating an instance of the class calender //
      ClinicCalendar calendar = new ClinicCalendar();
      // EXECUTE / Adding an appointment to the calender //
      calendar.addAppointment("Jim", "Weaver", "avery", "09/01/2018 2:00 pm");
      // EXECUTE / Now we use the getAppointments method on the calendar to assign it to the variable appointments List //
      List<PatientAppointment> appointments = calendar.getAppointments();
      // VERIFY / We use the assertNotNull method on the appointments list to verify if the list is not null //
      assertNotNull(appointments);
      // VERIFY / Let's verify if there is at least one appointment on the list //
      assertEquals(1, appointments.size());
      PatientAppointment enteredAppt = appointments.get(0);
      assertEquals("Jim",enteredAppt.getPatientFirstName());
      assertEquals("Weaver",enteredAppt.getPatientLastName());
      assertEquals(Doctor.avery, enteredAppt.getDoctor());
      assertEquals("9/1/2018 02:00 PM",enteredAppt.getAppointmentDateTime().format(DateTimeFormatter.ofPattern("M/d/yyyy hh:mm a")));
   }

}