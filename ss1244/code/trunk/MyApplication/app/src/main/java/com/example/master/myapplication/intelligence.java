package com.example.master.myapplication;

import java.util.Random;

/**
 * Created by shaheer saleem on 3/23/2021.
 */
public class intelligence {
    public static final Random RANDOM = new Random();

 public char[] sharo;

    public char player;

 public boolean over;

    public char AI() {
        if (!over) {

            int place = -1;

    do {
           place = RANDOM.nextInt(9);
      } while (sharo[place] != ' ');

            sharo[place] = player;

            diffplayer();
        }

        return finish();
    }





    public intelligence() {

        sharo = new char[9];

      reset();
    }
    public void reset() {

      for (int i = 0; i < sharo.length; i++) {

      sharo[i] = ' ';
        }

      player = 'X';

         over = false;
    }
      public boolean over() {

           return over;

    }
    public void diffplayer() {

       player = (player == 'X' ? 'O' : 'X');

    }
       public char play(int x, int y) {

     if (!over && sharo[3 * y + x] == ' ') {

       sharo[3 * y + x] = player;

           diffplayer();
        }
             return finish();
    }



    public char get1(int x, int y) {

        return sharo[3 * y + x];
    }



    public char finish() {
        for (int i = 0; i < 3; i++) {

            if (get1(i, 0) != ' ' &&

    get1(i, 0) == get1(i, 1) &&

       get1(i, 1) == get1(i, 2)) {

          over = true;

          return get1(i, 0);

            }

            if (get1(0, i) != ' ' &&

             get1(0, i) == get1(1, i) &&

              get1(1, i) == get1(2, i)) {

       over = true;

          return get1(0, i);

            }
        }

        if (get1(0, 0) != ' ' &&
         get1(0, 0) == get1(1, 1) &&

       get1(1, 1) == get1(2, 2)) {

            over = true;
            return get1(0, 0);
        }

        if (get1(2, 0) != ' ' &&
    get1(2, 0) == get1(1, 1) &&

       get1(1, 1) == get1(0, 2)) {

            over = true;
            return get1(2, 0);
        }

        for (int i = 0; i < 9; i++) {

            if (sharo[i] == ' ')
                return ' ';
        }

        return 'T';
    }


}
