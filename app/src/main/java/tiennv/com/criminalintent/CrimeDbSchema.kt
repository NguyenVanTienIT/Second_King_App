package tiennv.com.criminalintent

/**
 * Created by suale on 4/24/18.
 */
class CrimeDbSchema {

    companion object {

        public class CrimeTable {

            companion object {
                public var NAME : String = "crimes"


                public class Cols {

                    companion object {
                        public var UUID : String = "uuid"
                        public var TITLE : String = "title"
                        public var DATE : String = "date"
                        public var SOLVED : String = "solved"
                    }

                }

            }

        }



    }


}