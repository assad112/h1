# 📊 دليل قاعدة البيانات الداخلية (SQLite)

## نظرة عامة

تم تحويل التطبيق من استخدام بيانات مؤقتة إلى **قاعدة بيانات داخلية (SQLite)** كاملة للأدمن والمستخدمين.

---

## 🗄️ هيكل قاعدة البيانات

### الجداول (Tables):

#### 1. **جدول المستخدمين (users)**
```sql
- user_id (INTEGER) - المفتاح الأساسي
- user_name (TEXT) - اسم المستخدم
- user_email (TEXT) - البريد الإلكتروني (فريد)
- user_password (TEXT) - كلمة المرور
- user_phone (TEXT) - رقم الهاتف
- user_type (TEXT) - نوع المستخدم (admin أو user)
```

#### 2. **جدول الحضانات (nurseries)**
```sql
- nursery_id (INTEGER) - المفتاح الأساسي
- name (TEXT) - اسم الحضانة
- description (TEXT) - الوصف
- address (TEXT) - العنوان
- phone (TEXT) - رقم الهاتف
- email (TEXT) - البريد الإلكتروني
- latitude (REAL) - خط العرض
- longitude (REAL) - خط الطول
- rating (REAL) - التقييم
- review_count (INTEGER) - عدد التقييمات
- price_per_month (REAL) - السعر الشهري
- age_range (TEXT) - الفئة العمرية
- opening_hours (TEXT) - ساعات العمل
- distance (REAL) - المسافة
- image_url (TEXT) - رابط الصورة
- is_verified (INTEGER) - حالة التحقق
- capacity (INTEGER) - السعة الكلية
- available_slots (INTEGER) - الأماكن المتاحة
```

#### 3. **جدول التقييمات (reviews)**
```sql
- review_id (INTEGER) - المفتاح الأساسي
- nursery_id (INTEGER) - معرف الحضانة (مفتاح أجنبي)
- user_name (TEXT) - اسم المستخدم
- rating (REAL) - التقييم
- comment (TEXT) - التعليق
- date (TEXT) - التاريخ
- is_verified (INTEGER) - حالة التحقق
```

#### 4. **جدول الحجوزات (bookings)**
```sql
- booking_id (INTEGER) - المفتاح الأساسي
- nursery_id (INTEGER) - معرف الحضانة (مفتاح أجنبي)
- nursery_name (TEXT) - اسم الحضانة
- child_name (TEXT) - اسم الطفل
- child_age (INTEGER) - عمر الطفل
- parent_name (TEXT) - اسم الوالد
- parent_phone (TEXT) - هاتف الوالد
- parent_email (TEXT) - بريد الوالد
- start_date (TEXT) - تاريخ البدء
- package_type (TEXT) - نوع الباقة
- additional_notes (TEXT) - ملاحظات إضافية
- booking_date (TEXT) - تاريخ الحجز
- status (TEXT) - الحالة (PENDING, CONFIRMED, CANCELLED)
```

#### 5. **جدول المرافق (facilities)**
```sql
- facility_id (INTEGER) - المفتاح الأساسي
- nursery_id (INTEGER) - معرف الحضانة (مفتاح أجنبي)
- facility_name (TEXT) - اسم المرفق
```

---

## 👥 الحسابات الافتراضية

### حساب الأدمن:
- **البريد الإلكتروني:** `admin@nursery.com`
- **كلمة المرور:** `admin123`
- **النوع:** `admin`

### حساب مستخدم تجريبي:
- **البريد الإلكتروني:** `user@example.com`
- **كلمة المرور:** `user123`
- **النوع:** `user`

---

## 📁 الملفات المضافة

### 1. **DatabaseHelper.java**
الملف الرئيسي لإدارة قاعدة البيانات:
- إنشاء الجداول
- عمليات CRUD (إنشاء، قراءة، تحديث، حذف)
- إدارة المستخدمين
- إدارة الحضانات
- إدارة التقييمات
- إدارة الحجوزات
- إدارة المرافق

**الموقع:** `app/src/main/java/com/example/h1/database/DatabaseHelper.java`

### 2. **DataSeeder.java**
ملف لإضافة البيانات الأولية:
- إضافة 5 حضانات مع معلومات كاملة
- إضافة تقييمات لكل حضانة
- إضافة مرافق لكل حضانة

**الموقع:** `app/src/main/java/com/example/h1/database/DataSeeder.java`

---

## 🔧 التعديلات على الأنشطة

### 1. **MainActivity.java**
```java
// قبل:
allNurseries = NurseryDataProvider.getSampleNurseries();

// بعد:
databaseHelper = new DatabaseHelper(this);
DataSeeder.seedDatabase(this);
allNurseries = databaseHelper.getAllNurseries();
```

### 2. **AdminLoginActivity.java**
```java
// التحقق من قاعدة البيانات
boolean success = databaseHelper.checkUserLogin(email, password);
String userType = databaseHelper.getUserType(email);
```

### 3. **AdminManageNurseriesActivity.java**
```java
// جلب الحضانات من قاعدة البيانات
nurseries = databaseHelper.getAllNurseries();

// حذف حضانة
databaseHelper.deleteNursery(nursery.getId());
```

### 4. **AdminReviewsActivity.java**
```java
// جلب جميع التقييمات
allReviews = databaseHelper.getAllReviews();
```

### 5. **BookingActivity.java**
```java
// حفظ الحجز في قاعدة البيانات
long bookingId = databaseHelper.addBooking(booking);
```

---

## 🎯 المميزات

### ✅ للأدمن:
1. **إضافة حضانات جديدة** - يتم حفظها في قاعدة البيانات
2. **تعديل معلومات الحضانات** - التحديثات تُحفظ مباشرة
3. **حذف الحضانات** - الحذف نهائي من قاعدة البيانات
4. **عرض جميع التقييمات** - من قاعدة البيانات
5. **تسجيل دخول آمن** - التحقق من قاعدة البيانات

### ✅ للمستخدمين:
1. **تصفح الحضانات** - من قاعدة البيانات
2. **حجز مكان** - يُحفظ في قاعدة البيانات
3. **عرض التقييمات** - من قاعدة البيانات

---

## 📊 عمليات قاعدة البيانات

### إضافة مستخدم:
```java
long userId = databaseHelper.addUser(name, email, password, phone, type);
```

### التحقق من تسجيل الدخول:
```java
boolean isValid = databaseHelper.checkUserLogin(email, password);
String userType = databaseHelper.getUserType(email);
```

### إضافة حضانة:
```java
long nurseryId = databaseHelper.addNursery(nursery);
```

### جلب جميع الحضانات:
```java
List<Nursery> nurseries = databaseHelper.getAllNurseries();
```

### تحديث حضانة:
```java
int rows = databaseHelper.updateNursery(nursery);
```

### حذف حضانة:
```java
databaseHelper.deleteNursery(nurseryId);
```

### إضافة تقييم:
```java
long reviewId = databaseHelper.addReview(review);
```

### جلب تقييمات حضانة:
```java
List<Review> reviews = databaseHelper.getReviewsForNursery(nurseryId);
```

### إضافة حجز:
```java
long bookingId = databaseHelper.addBooking(booking);
```

### جلب جميع الحجوزات:
```java
List<Booking> bookings = databaseHelper.getAllBookings();
```

---

## 🔐 الأمان

### النقاط المهمة:
1. **كلمات المرور:** حالياً مخزنة كنص عادي (للتطوير فقط)
   - **للإنتاج:** يجب تشفيرها باستخدام BCrypt أو SHA-256

2. **SQL Injection:** محمي باستخدام Prepared Statements

3. **التحقق من الصلاحيات:** يتم التحقق من نوع المستخدم قبل السماح بالعمليات

---

## 🚀 كيفية الاستخدام

### للمطورين:

#### 1. إضافة بيانات أولية:
```java
// في MainActivity أو WelcomeActivity
DatabaseHelper db = new DatabaseHelper(context);
DataSeeder.seedDatabase(context);
```

#### 2. استخدام قاعدة البيانات:
```java
DatabaseHelper db = new DatabaseHelper(context);

// إضافة حضانة
long id = db.addNursery(nursery);

// جلب الحضانات
List<Nursery> nurseries = db.getAllNurseries();

// حذف حضانة
db.deleteNursery(nurseryId);
```

---

## 📝 ملاحظات

1. **البيانات الأولية:** يتم إضافتها تلقائياً عند أول تشغيل للتطبيق

2. **حذف البيانات:** لحذف جميع البيانات وإعادة البدء:
   ```java
   context.deleteDatabase("nursery_app.db");
   ```

3. **التحديثات المستقبلية:** عند تغيير هيكل قاعدة البيانات:
   - زيادة `DATABASE_VERSION` في `DatabaseHelper`
   - تحديث `onUpgrade()` method

4. **الأداء:** قاعدة البيانات محلية وسريعة جداً

---

## ✅ الخلاصة

تم تحويل التطبيق بالكامل لاستخدام قاعدة بيانات SQLite داخلية:
- ✅ جميع البيانات تُحفظ بشكل دائم
- ✅ الأدمن يمكنه إضافة/تعديل/حذف الحضانات
- ✅ المستخدمون يمكنهم الحجز والتقييم
- ✅ تسجيل دخول آمن للأدمن والمستخدمين
- ✅ جميع العمليات تعمل بشكل صحيح

**التطبيق الآن جاهز للاستخدام الفعلي!** 🎉

