# 📊 Class Diagram - الشرح

## نظرة عامة
مخطط الفئات (Class Diagram) يوضح فئات النظام، خصائصها (Attributes)، دوالها (Methods)، والعلاقات بينها (Relationships). يستخدم في البرمجة الكائنية (OOP).

## شرح المخطط

### 📦 الفئات (Classes)

#### 1. **Model Classes (فئات النماذج)**

##### **Nursery**
- **النوع**: Model Class
- **الخصائص (Attributes)**:
  - `id`, `name`, `description`, `address`
  - `phone`, `email`, `latitude`, `longitude`
  - `rating`, `reviewCount`, `pricePerMonth`
  - `ageRange`, `openingHours`, `distance`
  - `imageUrl`, `facilities`, `reviews`
  - `isVerified`, `capacity`, `availableSlots`
- **الدوال (Methods)**:
  - Getters: `getId()`, `getName()`, `getDescription()`
  - Setters: `setId()`, `setName()`, etc.
  - `addFacility(String)`: إضافة مرفق
  - `addReview(Review)`: إضافة تقييم
  - `getFacilities()`, `getReviews()`: الحصول على القوائم

##### **Review**
- **النوع**: Model Class
- **الخصائص**:
  - `id`, `nurseryId`, `userName`
  - `rating`, `comment`, `date`, `isVerified`
- **الدوال**: Getters و Setters

##### **Booking**
- **النوع**: Model Class
- **الخصائص**:
  - `id`, `nurseryId`, `nurseryName`
  - `childName`, `childAge`
  - `parentName`, `parentPhone`, `parentEmail`
  - `startDate`, `packageType`, `additionalNotes`
  - `bookingDate`, `status`
- **الدوال**: Getters, Setters, `setStatus()`

#### 2. **Activity Classes (فئات الشاشات)**

##### **MainActivity**
- **النوع**: Activity (extends AppCompatActivity)
- **الخصائص**:
  - `recyclerView`: لعرض القائمة
  - `adapter`: محول البيانات
  - `allNurseries`: قائمة جميع الحضانات
  - `searchEditText`: حقل البحث
  - `btnFilter`, `btnSort`: أزرار
  - `currentFilter`: معايير الفلترة الحالية
- **الدوال**:
  - `onCreate()`: تهيئة الشاشة
  - `initViews()`: تهيئة العناصر
  - `setupRecyclerView()`: إعداد القائمة
  - `setupSearch()`: إعداد البحث
  - `loadNurseries()`: تحميل البيانات
  - `applyFilters()`: تطبيق الفلاتر
  - `showFilterDialog()`, `showSortDialog()`: عرض الحوارات

##### **NurseryDetailsActivity**
- **النوع**: Activity
- **الخصائص**:
  - `nursery`: بيانات الحضانة
  - `reviewAdapter`: محول التقييمات
  - `recyclerView`: قائمة التقييمات
- **الدوال**:
  - `onCreate()`: تهيئة الشاشة
  - `displayNurseryDetails()`: عرض التفاصيل
  - `setupReviewList()`: إعداد قائمة التقييمات
  - `onCallClick()`: الاتصال
  - `onMapClick()`: فتح الخريطة
  - `onBookClick()`: الانتقال للحجز

##### **BookingActivity**
- **النوع**: Activity
- **الخصائص**:
  - `nursery`: بيانات الحضانة
  - `packageType`: نوع الباقة
  - `startDate`: تاريخ البدء
- **الدوال**:
  - `onCreate()`: تهيئة الشاشة
  - `setupDatePicker()`: إعداد منتقي التاريخ
  - `onSubmitBooking()`: إرسال الحجز
  - `validateForm()`: التحقق من البيانات

#### 3. **Adapter Classes (فئات المحولات)**

##### **NurseryAdapter**
- **النوع**: RecyclerView.Adapter
- **الخصائص**:
  - `nurseries`: قائمة الحضانات
  - `listener`: مستمع النقرات
- **الدوال**:
  - `onCreateViewHolder()`: إنشاء عنصر العرض
  - `onBindViewHolder()`: ربط البيانات
  - `getItemCount()`: عدد العناصر
  - `setOnItemClickListener()`: تعيين المستمع

##### **ReviewAdapter**
- **النوع**: RecyclerView.Adapter
- **الخصائص**: `reviews`
- **الدوال**: مشابهة لـ NurseryAdapter

#### 4. **Utility Classes (فئات المساعدة)**

##### **FilterHelper**
- **النوع**: Utility Class (Static Methods)
- **الدوال**:
  - `filter(List<Nursery>, FilterCriteria)`: فلترة القائمة
  - `sort(List<Nursery>, String)`: ترتيب القائمة
  - `calculateDistance()`: حساب المسافة

##### **BookingManager**
- **النوع**: Utility Class
- **الخصائص**: `bookings`
- **الدوال**:
  - `createBooking(Booking)`: إنشاء حجز
  - `validateBooking(Booking)`: التحقق من الحجز
  - `getAllBookings()`: جميع الحجوزات
  - `getBookingById(int)`: حجز محدد

##### **NurseryDataProvider**
- **النوع**: Utility Class (Static Methods)
- **الدوال**:
  - `getSampleNurseries()`: الحصول على بيانات تجريبية
  - `getNurseryById(int)`: حضانة محددة

### 🔗 العلاقات (Relationships)

#### 1. **Association (ارتباط)**
- **MainActivity** → uses → **Nursery**: يستخدم بيانات الحضانة
- **NurseryDetailsActivity** → uses → **Nursery**: يعرض بيانات الحضانة
- **BookingActivity** → uses → **Booking**: يستخدم بيانات الحجز

#### 2. **Composition (تكوين)**
- **Nursery** ◇→ **Review**: الحضانة تحتوي على تقييمات (علاقة قوية)

#### 3. **Dependency (اعتماد)**
- **MainActivity** → uses → **NurseryAdapter**: يعتمد على المحول
- **MainActivity** → uses → **FilterHelper**: يعتمد على المساعد
- **MainActivity** → uses → **NurseryDataProvider**: يعتمد على مزود البيانات

## رموز UML المستخدمة

- **-**: Private (خاص)
- **+**: Public (عام)
- **─────────────────**: فاصل بين الخصائص والدوال
- **<<Model>>**: Stereotype (نوع الفئة)
- **→**: Association (ارتباط)
- **◇→**: Composition (تكوين)

## مثال على الاستخدام

```java
// MainActivity يستخدم Nursery
MainActivity activity = new MainActivity();
List<Nursery> nurseries = NurseryDataProvider.getSampleNurseries();
activity.allNurseries = nurseries;

// NurseryAdapter يعرض Nursery
NurseryAdapter adapter = new NurseryAdapter(nurseries);
recyclerView.setAdapter(adapter);

// FilterHelper يفلتر القائمة
FilterCriteria criteria = new FilterCriteria();
criteria.maxPrice = 900;
List<Nursery> filtered = FilterHelper.filter(nurseries, criteria);
```

## الفائدة من هذا المخطط

✅ **تصميم الكود**: يساعد في تصميم الفئات قبل البرمجة
✅ **فهم البنية**: يوضح كيف ترتبط الفئات ببعضها
✅ **التوثيق**: وثيقة مهمة للمطورين
✅ **الصيانة**: يسهل فهم الكود عند الصيانة
✅ **التطوير**: نقطة انطلاق للتطوير المستقبلي

## ملاحظات مهمة

- هذا المخطط يتبع نمط MVC (Model-View-Controller)
- Model Classes: البيانات
- Activity Classes: الواجهة (View)
- Utility Classes: المنطق (Controller)
- Adapter Classes: ربط البيانات بالواجهة



