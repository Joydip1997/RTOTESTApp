<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".fun1">


    <ScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:layout_editor_absoluteX="-40dp"
        tools:layout_editor_absoluteY="0dp">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical">

        <ImageView
            android:id="@+id/Fun0"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginStart="0dp"
            android:layout_marginLeft="8dp"
            android:layout_marginEnd="8dp"
            android:layout_marginTop="1dp"
            android:layout_marginRight="8dp"
            android:layout_marginBottom="8dp"
            android:background="@drawable/fun1_0"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.015"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            app:layout_constraintVertical_bias="0.011" />


        <ImageView
            android:id="@+id/Fun1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginStart="0dp"
            android:layout_marginLeft="8dp"
            android:layout_marginTop="1dp"
            android:layout_marginEnd="8dp"
            android:layout_marginRight="8dp"
            android:layout_marginBottom="8dp"
            android:background="@drawable/fun1_1"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.015"
            app:layout_constraintStart_toStartOf="pare