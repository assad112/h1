# Quick Start Guide - Nursery Finder App

## 📱 How to Run the Application

### Prerequisites
- Android Studio (latest version recommended)
- Android SDK with API Level 28 or higher
- Android device or emulator running Android 9.0 (Pie) or newer

### Steps to Run

1. **Open in Android Studio**
   - Launch Android Studio
   - Click "Open an Existing Project"
   - Navigate to the project folder and select it

2. **Sync Gradle**
   - Android Studio will automatically prompt to sync Gradle
   - Wait for the sync to complete
   - If prompted, accept any SDK or build tools updates

3. **Build the Project**
   - Click "Build" → "Make Project" from the menu
   - Wait for the build to complete
   - Ensure there are no errors

4. **Run the Application**
   - Connect an Android device via USB (with USB debugging enabled)
   - OR start an Android emulator from AVD Manager
   - Click the green "Run" button (▶) or press Shift+F10
   - Select your device/emulator
   - Wait for the app to install and launch

## 🎯 Using the Application

### Main Features Walkthrough

#### 1. Search for Nurseries
- **Search Bar**: Type nursery name, location, or keywords
- The list updates in real-time as you type
- Clear the search to see all nurseries

#### 2. Filter Nurseries
- Tap the **Filter icon** (☰) in the top right
- Adjust sliders for:
  - Maximum price (up to $2000/month)
  - Minimum rating (0-5 stars)
  - Maximum distance (up to 100 km)
- Tap **Apply Filters** to see results
- Tap **Clear Filters** to reset

#### 3. Sort Results
- Tap the **Sort icon** (⋮) in the top right
- Choose from:
  - Highest Rating
  - Price: Low to High
  - Price: High to Low
  - Nearest First

#### 4. View Nursery Details
- Tap any nursery card to see full details
- Scroll through:
  - Description
  - Contact information
  - Operating hours
  - Facilities
  - Reviews from parents
- Use action buttons:
  - **Call Now**: Opens phone dialer
  - **View Location**: Opens in Google Maps
  - **Book Now**: Go to booking form

#### 5. Book a Nursery
- From the details page, tap **Book Now**
- Fill in the booking form:
  - **Child Information**: Name and age
  - **Parent Information**: Name, phone, email
  - **Start Date**: Select from calendar
  - **Package Type**: Choose Full Time, Part Time, or Hourly
  - **Notes**: Add any special requirements
- Tap **Submit Booking**
- You'll see a confirmation dialog

## 📊 Sample Data

The app comes pre-loaded with 8 sample nurseries showcasing different features:

- **Budget Options**: $650-$850/month
- **Mid-Range**: $900-$950/month
- **Premium**: $1050-$1100/month

Each nursery has:
- Complete contact details
- Multiple facilities
- Real reviews
- Availability status

## 🎨 UI Features

### Visual Indicators
- **Green text**: Available slots
- **Red text**: Fully booked
- **Star ratings**: Quality indicator
- **Distance**: Proximity to you
- **Price**: Monthly cost

### Card Design
- Each nursery card shows key information at a glance
- Tap cards for more details
- Cards have subtle shadows and rounded corners
- Color-coded badges for ratings

## 🔧 Troubleshooting

### App Won't Build
- Ensure you have Android SDK API 28 or higher installed
- Sync Gradle files (File → Sync Project with Gradle Files)
- Clean and rebuild (Build → Clean Project, then Build → Rebuild Project)

### App Crashes on Launch
- Check that your device/emulator is API 28+
- Clear app data and reinstall
- Check logcat for error messages

### Permissions Issues
- Grant phone and location permissions when prompted
- Some features (calling, maps) require these permissions

### No Nurseries Showing
- Clear any active filters
- Check the search bar is empty
- Restart the app

## 💡 Tips & Tricks

1. **Quick Access**: Recently viewed nurseries appear first
2. **Compare**: Open multiple details by using back button
3. **Filter Combos**: Use price AND rating filters together
4. **Sort After Filter**: Apply filters first, then sort for best results
5. **Bookmark**: Note down favorite nurseries for later

## 📞 Contact Features

### Calling a Nursery
- Tap "Call Now" button
- Your phone's dialer opens with the number
- Tap call to connect

### Viewing Location
- Tap "View Location" button
- Requires Google Maps installed
- Shows nursery address on map
- Get directions from your location

## 🎯 Best Practices

1. **Filter First**: Narrow down options before browsing
2. **Read Reviews**: Check what other parents say
3. **Check Availability**: Look for available slots indicator
4. **Compare Facilities**: Each nursery lists amenities
5. **Book Early**: Limited slots available

## 🔄 App Navigation

- **Back Button**: Returns to previous screen
- **Up Navigation**: Top-left arrow returns to parent screen
- **Card Tap**: Opens detailed view
- **Dialog Close**: Tap outside or use buttons

## 📱 Screen Orientations

- App is locked to **portrait mode** for optimal viewing
- All screens designed for one-handed use
- Scrollable content for longer pages

## ⚡ Performance

- Instant search results
- Smooth scrolling
- Fast page transitions
- Lightweight design
- Efficient memory usage

---

**Enjoy finding the perfect nursery for your child! 👶**

