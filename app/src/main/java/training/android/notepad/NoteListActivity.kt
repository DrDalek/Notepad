package training.android.notepad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_note_list.*

class NoteListActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var notes: MutableList<Note>
    lateinit var adapter : NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)

        notes = mutableListOf()
        notes.add(Note("RDV","Rendez vous à la gare à Noel"))
        notes.add(Note("Note 2","Je dois mettre une note ici"))
        notes.add(Note("Mémo draco","c'est quoi draco?"))
        notes.add(Note("Musique","Blacko cartonne en ce moment sur NRJ Radio, à écouter absolument"))
        notes.add(Note("Films","Les films les plus attendus cette année sont georgette et carlito"))

        adapter = NoteAdapter(notes, this)

        notes_recycler_view.layoutManager = LinearLayoutManager(this)
        notes_recycler_view.adapter = adapter
    }

    override fun onClick(view: View) {
        if (view.tag != null) {
            val position = view.tag as Int
            Log.i(this.javaClass.simpleName, "click sur ${notes[position].title}")
        }
    }
}
