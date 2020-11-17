package patientintake;

import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import static org.junit.jupiter.api.Assertions.*;

class ClinicCalendarShould {
   private ClinicCalendar calendar;
      /* Writing your first Test
      Its exercising several classes but not the ClinicMain class because it contains mostly methods to process the
      users input. We will focus on the business process of the application.
      1. Create a test class
      2. Begin a new Test method with @Test
      3. Write your method starting with public void nameOfTheMethod() { }
      4. Now we are going to SETUP - EXECUTE - VERIFY the code
    */
   @BeforeAll
   static void testClassSetup() {
      System.out.println("Before all...");
   }

   @BeforeEach
   void init() {
      System.out.println("Before each...");
      calendar = new ClinicCalendar(LocalDate.of(2018,8,26));
   }
   @Test // Annotations provide metadata for the program //
   void allowEntryOfAnAppointment() {
      // SETUP is now put in the BeforeEach //
      // EXECUTE //
      // Then call the addAppointment method on the calendar to add data for the test //
      System.out.println("entry of appointment...");
      calendar.addAppointment("Jim", "Weaver", "avery","09/01/2018 2:00 pm");
      // Now we need to verify if the results matches the input //
      // Let's call the getAppointments method on the calender and store these in a variable "appointments" //
      List<PatientAppointment> appointments = calendar.getAppointments(LocalDate.of(2018, 8, 26));
      // VERIFY //
      // That calender should contain the appointment if it works correctly //
      // 1. We verify that the appointments on the calender is not null with the assertNotNull(); operation //
      assertNotNull(appointments);
      // 2. Let's check that the appointment is ont the calender with the assertEquals(expected value, system value); operation //
      assertEquals(1, appointments.size());
      PatientAppointment enteredAppt = appointments.get(0);
      assertEquals("Jim", enteredAppt.getPatientFirstName());
      assertEquals("Weaver", enteredAppt.getPatientLastName());
      // 3. assertSame method will verify that the two variables points to the same object in memory. Enumerations are unique so //
      //    it should be exactly the same. //
      assertSame(Doctor.avery, enteredAppt.getDoctor());
      assertEquals("9/1/2018 02:00 PM",
         enteredAppt.getAppointmentDateTime().format(DateTimeFormatter.ofPattern("M/d/yyyy hh:mm a", Locale.US)));
   }

   @Test
   void returnTrueForHasAppointmentsIfThereAreAppointments() {
      calendar.addAppointment("Jim","Weaver","avery", "09/01/2018 2:00 pm");
      assertTrue(calendar.hasAppointment(LocalDate.of(2018,9,1)));
   }
   // They use two assertions, assertTrue and assertFalse. So this feature should return true if there's an appointment //
   // scheduled on the input day and false if not.                                                                     //
   @Test
   void returnFalsForHasAppointmentsIfThereAreNoAppointments() {
      assertFalse(this.calendar.hasAppointment(LocalDate.of(2018,9,1)));
   }

   // It enters the same appointments that we just did manually through the user interface.
   @Test
   void returnCurrentDaysAppointments() {
      // calendar = new ClinicCalendar(LocalDate.of(2018,8,26));// Now I'm passing literally the day the test was run into the
      // calendar as today. So tomorrow this test is going to fail, but we'll fix that later in this module.
      this.calendar.addAppointment("Jim", "Weaver", "avery", "08/26/2018 2:00 pm");
      this.calendar.addAppointment("Jim", "Weaver", "avery", "08/26/2018 3:00 pm");
      this.calendar.addAppointment("Jim", "Weaver", "avery", "09/01/2018 2:00 pm");
      // It verifies that it gets the two appointments back for the current day that we should expect. And that test runs.
      assertEquals(2, this.calendar.getTodayAppointments().size());
      // Let's try an assertEquals on a collection. We'll compare today's appointments from the calendar, which we know is
      // going to be two in this case, to all the appointments. We'd expect that to fail, and it does.
      // assertIterableEquals(calendar.getTodayAppointments(), calendar.getAppointments(LocalDate.now()));
   }

   @AfterEach
   void tearDownEachTest() {
      System.out.println("After each test...");
   }

   @AfterAll
   static void testDownTestClass(){
      System.out.println("After all tests...");
   }
}