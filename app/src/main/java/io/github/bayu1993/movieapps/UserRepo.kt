package io.github.bayu1993.movieapps

/**
 * Created by Bayu teguh pamuji on 12/4/18.
 * email : bayuteguhpamuji@gmail.com.
 */
class UserRepo {
    fun getDataUser(){

    }
}
//dependency
class ProfilePresenter(val userRepo: UserRepo){
    //val userRepo = UserRepo()
    fun getDataUser(){
        userRepo.getDataUser()
    }
}

class UserActivity{
    val userRepo = UserRepo()
    //injection
    val presenter = ProfilePresenter(userRepo)
}