# Hostel Guide
A simple Android Application for Hostel booking and Recommendations.

# Problem Statement - “Create a Hostel Booking & Recommendation Platform” with the following specifications -
1. Take a sample JSON for a list of Hostels
2. The hostel shall have most basic identifying fields
3. Create a few users who will perform the following activities 
4. Track the visitors on a hostel page
5. Users make a Draft Booking, where the user tries to book a hostel but don't complete the process
6. Users book a Hostel i.e. Create a completed booking
7. Display the activities happening around hostel page (Visits, Draft Bookings, Completed Booking)
8. Display recommendations of other hostels based on the activities done by the user.
9. Implement a basic UI with minimal functionality required.
 
 # Technology Stack : 
Android (AndroidX)
XML and Java
Libraries -> GSON , JackSon Faster XML , Adapters , 
XML Components -> Recycler Views , Card Views , Collapsing Toolbars.
 
# Application Flow
1. User Login (Dummy Users Created)
2. Views a List of Hostels (Dummy Hostels with basic Information)
3. Can View Detailed Information of each Hostel.
4. Scrol down to view Recommended Hostels.
5. Book a Hostel.
6. Draft book a hostel (Save for later).
7. View a hostel from the recommendations.

# Recommendations logic
If the user has no bookings then Hostel are recommended on the basis of the **location** of the Hostel user is currently viewing.
Or else based on the **similarity of features** of the previously booked Hostels.

User and Hostel information stored in assets folder as a Users.json and Hostel.json files respectively .
Bookings and Draft Booking details are stored in SharedPreferences as a json string.

