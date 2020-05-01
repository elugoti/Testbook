package android.app.testbook.ui


import android.annotation.SuppressLint
import android.app.testbook.R
import android.app.testbook.data.Class
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

class CourseListAdapter : ListAdapter<Class, CourseListAdapter.ItemViewholder>(DiffCallback())  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false);
        //view.layoutParams = ViewGroup.LayoutParams((parent.width * 0.9).toInt(),ViewGroup.LayoutParams.WRAP_CONTENT)
        return ItemViewholder(view);
    }

    override fun onBindViewHolder(holder: ItemViewholder, position: Int) {
        holder.bind(getItem(position))
    }

    class ItemViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Class) = with(itemView) {
            var mainLayout = itemView.findViewById<CardView>(R.id.cardMain)
            var tvCourseTitle = itemView.findViewById<TextView>(R.id.tvCourseTitle)
            var imgFaculty = itemView.findViewById<ImageView>(R.id.imgFaculty)

            var classProperties = item.classProperties
            var classInfo = item.classInfo

            if(!classProperties?.color.isNullOrEmpty()){
                mainLayout.setBackgroundColor(Color.parseColor("#"+classProperties?.color))
            }

            tvCourseTitle.setText(item.titles)
            var imgUrl = classInfo?.facultiesImage
            if (imgUrl?.isNotEmpty()!!) {
                imgUrl = "https:$imgUrl"
                Glide.with(itemView.context)
                    .load(imgUrl)
                    .error(R.drawable.sample)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(imgFaculty)
            } else {

            }

        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<Class>() {
    override fun areItemsTheSame(oldItem: Class, newItem: Class): Boolean {
        return oldItem._id == newItem._id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: Class, newItem: Class): Boolean {
        return oldItem == newItem
    }

}