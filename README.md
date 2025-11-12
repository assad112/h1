# Warm Clouds ☁️ - Nursery Finder App

A professional, feature-rich Android application for searching and booking nurseries/daycares in your area. Built with Java and Material Design principles.

**"Where children find comfort and care"**

## Features

### 🔍 Search & Discovery
- **Smart Search**: Search nurseries by name, location, or description
- **Advanced Filtering**: Filter by price range, rating, distance, and age group
- **Multiple Sort Options**: Sort by rating, price (low to high/high to low), or distance
- **Real-time Results**: Instant search and filter results

### 🏫 Nursery Information
- **Detailed Profiles**: Complete information about each nursery including:
  - Description and overview
  - Price per month
  - Age range accepted
  - Opening hours
  - Contact information (phone, email, address)
  - Capacity and available slots
  - Facilities and amenities
  - Location with map integration
- **Rating System**: Star ratings with review counts
- **Distance Display**: Shows distance from user location
- **Verified Status**: Indicates verified nurseries

### ⭐ Reviews & Ratings
- View reviews from other parents
- See ratings for each nursery
- Verified reviewer badges
- Date stamps for reviews

### 📅 Booking System
- **Easy Booking Process**: Simple form to book a nursery spot
- **Multiple Packages**:
  - Full Time (8 hours)
  - Part Time (4 hours)
  - Hourly
- **Date Selection**: Calendar picker for start date
- **Complete Information Collection**:
  - Child details (name, age)
  - Parent details (name, phone, email)
  - Additional notes
- **Booking Confirmation**: Success dialog with confirmation

### 🎨 Modern Design
- **Material Design 3**: Latest Material Design components
- **Clean UI**: Modern, professional interface
- **Responsive Layouts**: Optimized for different screen sizes
- **Card-based Design**: Easy-to-scan information cards
- **Color-coded Information**: Visual indicators for availability, ratings, etc.
- **Custom Theme**: Beautiful color scheme with primary indigo and accent amber
- **Dark Mode Support**: Automatic dark/light theme switching

### 📱 Additional Features
- **Call Integration**: Direct call to nursery from details page
- **Map Integration**: Open location in Google Maps
- **Availability Status**: Real-time slot availability
- **Capacity Information**: Shows total capacity and available slots
- **Facilities Chips**: Visual display of nursery facilities

## Technical Details

### Architecture
- **Language**: Java
- **Min SDK**: 28 (Android 9.0)
- **Target SDK**: 35
- **Design Pattern**: MVC (Model-View-Controller)

### Components

#### Models
- `Nursery`: Complete nursery information model
- `Review`: Review and rating information
- `Booking`: Booking details and status

#### Activities
- `MainActivity`: Home screen with search, filter, and nursery list
- `NurseryDetailsActivity`: Detailed view of selected nursery
- `BookingActivity`: Booking form and submission

#### Adapters
- `NurseryAdapter`: RecyclerView adapter for nursery list
- `ReviewAdapter`: RecyclerView adapter for reviews

#### Utilities
- `NurseryDataProvider`: Sample data provider with 8 nurseries
- `FilterHelper`: Advanced filtering and sorting logic
- `BookingManager`: Booking management system

### Libraries & Dependencies
- AndroidX AppCompat
- Material Components
- RecyclerView
- CardView
- ConstraintLayout

## Sample Data

The app includes 8 sample nurseries with complete information:

1. **Bright Beginnings Nursery** - $850/month, 4.8★, Indoor playground, CCTV
2. **Little Stars Childcare** - $950/month, 4.6★, Swimming pool, Music classes
3. **Sunshine Kids Academy** - $650/month, 4.5★, Affordable, Daily activities
4. **Rainbow Montessori Center** - $1100/month, 4.9★, Montessori program, Bilingual
5. **Happy Hearts Daycare** - $750/month, 4.4★, Home-like environment, Organic meals
6. **Growing Minds Preschool** - $900/month, 4.7★, Kindergarten prep, Computer lab
7. **Tiny Tots Learning Center** - $800/month, 4.3★, Smart classrooms, STEM activities
8. **Precious Angels Nursery** - $1050/month, 4.8★, Low ratio, Infant care specialists

## User Interface

### Main Screen
- Search bar at the top
- Filter and sort buttons
- Result count display
- Scrollable list of nursery cards
- Each card shows: name, rating, address, price, distance, availability

### Nursery Details Screen
- Back button navigation
- Nursery name and rating
- Price card with prominent display
- About section
- Information section (hours, contact, capacity)
- Facilities as chips
- Reviews section
- Action buttons (Call, View Location, Book Now)

### Booking Screen
- Back button navigation
- Nursery name and price
- Child information form
- Parent information form
- Booking details (date, package type)
- Additional notes field
- Submit button

### Filter Dialog
- Price range slider (up to $2000)
- Minimum rating slider (0-5 stars)
- Distance slider (up to 100 km)
- Apply and Clear buttons

### Sort Dialog
- Sort by highest rating
- Sort by price (low to high)
- Sort by price (high to low)
- Sort by nearest first

## Color Scheme

- **Primary**: Indigo (#6366F1)
- **Primary Dark**: Deep Indigo (#4F46E5)
- **Primary Light**: Light Indigo (#A5B4FC)
- **Accent**: Amber (#F59E0B)
- **Success**: Green (#10B981)
- **Error**: Red (#EF4444)
- **Background**: Light Gray (#F9FAFB)

## Permissions

- `INTERNET`: For potential future API integration
- `CALL_PHONE`: To make direct calls to nurseries
- `ACCESS_FINE_LOCATION`: For location-based features
- `ACCESS_COARSE_LOCATION`: For distance calculations

## How to Build

1. Open the project in Android Studio
2. Sync Gradle files
3. Build the project
4. Run on an emulator or physical device (API 28+)

## Future Enhancements

- Integration with real API/database
- User authentication and profiles
- Photo galleries for nurseries
- Favorite/wishlist functionality
- Booking history
- Push notifications
- Real-time chat with nursery staff
- Payment integration
- Review submission
- Photo upload for nurseries
- GPS location tracking
- Multi-language support

## Developer Notes

- All text is in English as requested
- The app uses portrait orientation for all screens
- Sample data is provided for demonstration
- Booking system stores data in memory (can be extended to database)
- Professional, clean code with proper documentation
- Material Design 3 components for modern UI
- Optimized for Android 9.0 and above

## Contact

For questions or support, please contact the nurseries directly using the contact information provided in the app.

---

**Built with ❤️ for parents and caregivers**

