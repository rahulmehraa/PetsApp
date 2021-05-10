package com.example.petsapp.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;


/**
 * API Contract for the Pets app.
 */
public final class petContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private petContract() {}

    /**
     * Inner class that defines constant values for the pets database table.
     * Each entry in the table represents a single pet.
     */
    public static final class PetEntry implements BaseColumns {

        /** Name of database table for pets */
        public final static String TABLE_NAME = "pets";

        /**
         * Unique ID number for the pet (only for use in the database table).
         *
         * Type: INTEGER
         */
        public final static String _ID = BaseColumns._ID;

        /**
         * Name of the pet.
         *
         * Type: TEXT
         */
        public final static String COLUMN_PET_NAME ="name";

        /**
         * Breed of the pet.
         *
         * Type: TEXT
         */
        public final static String COLUMN_PET_BREED = "breed";

        /**
         * Gender of the pet.
         *
         * The only possible values are {@link #GENDER_UNKNOWN}, {@link #GENDER_MALE},
         * or {@link #GENDER_FEMALE}.
         *
         * Type: INTEGER
         */
        public final static String COLUMN_PET_GENDER = "gender";

        /**
         * Weight of the pet.
         *
         * Type: INTEGER
         */
        public final static String COLUMN_PET_WEIGHT = "weight";

        /**
         * Possible values for the gender of the pet.
         */
        public static final int GENDER_UNKNOWN = 0;
        public static final int GENDER_MALE = 1;
        public static final int GENDER_FEMALE = 2;

        /* Specifying the URI to access the content and to add CRUD methods*/
        public static final String CONTENT_AUTHORITY = "com.example.petsApp";

        /* Concatinate the Uri with the scheme */
        public static final Uri BASE_CONTENT_URI = Uri.parse("content://"+ CONTENT_AUTHORITY );

        /* Specify the path of the table */
        public static final String PATH_PETS = "pets";

        /*Pass the Uri and append the method and return it in the form of a Uri */
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI , PATH_PETS);

        /**
         * The MIME type of the {@link #CONTENT_URI} for a list of pets.
         */
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PETS;

        /**
         * The MIME type of the {@link #CONTENT_URI} for a single pet.
         */
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PETS;


        public static boolean isValidGender(Integer gender) {
            if(gender == GENDER_UNKNOWN || gender == GENDER_FEMALE || gender == GENDER_MALE){
                return true ;
            }
            return false ;
        }
    }

}
