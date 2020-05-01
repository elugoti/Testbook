package android.app.testbook.ui

import android.app.testbook.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearSnapHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var courseViewModel : CourseViewModel ? = null
    var adapter : CourseListAdapter ? = null
    var snapHelper = LinearSnapHelper()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        courseViewModel = ViewModelProviders.of(this).get(CourseViewModel::class.java)
        adapter = CourseListAdapter()
        rvCourses.adapter = adapter
        snapHelper.attachToRecyclerView(rvCourses)
        courseViewModel?.isPremium = true
        courseViewModel?.isIncludeIndividual = true

        courseViewModel?.getCourseList()?.observe(this, Observer {
            progressBar.visibility = View.GONE
            if(it!=null&&it.size>0){
                adapter?.submitList(it)
            }else{

            }
        })
    }
}
