package ru.netology.homework8

import java.lang.RuntimeException


data class Note(
    val noteId: Int = 0, var title: String = "", var text: String = "",
    var comment: MutableList<Comment> = mutableListOf()
)

data class Comment(val commentId: Int = 0, var text: String = "")

data class NoteList(val notes: MutableList<Note> = mutableListOf())

class NoNoteListException : RuntimeException()
class NoNoteException : RuntimeException()
class NoCommentException : RuntimeException()
object NoteService {
    private val noteLists = mutableMapOf<Int, NoteList>()
    private val tempComment: MutableList<Comment> = mutableListOf()

    fun addNote(userId: Int, note: Note) {

        noteLists.getOrPut(userId) { NoteList() }.notes.add(note)

    }

    fun addComment(userId: Int, noteId: Int, comment: Comment) {
        val noteList = noteLists[userId] ?: throw NoNoteListException()
       val note = noteList.notes.find { it.noteId == noteId } ?: throw NoNoteException()
        note.comment.add(comment)

    }

    fun deleteNote(userId: Int, noteId: Int) {
        val noteList = noteLists[userId] ?: throw NoNoteListException()
        noteList.notes.retainAll { it.noteId != noteId }

    }

    fun deleteComment(userId: Int, noteId: Int, commentId: Int) {
        val noteList = noteLists[userId] ?: throw NoNoteListException()
        val note = noteList.notes.find { it.noteId == noteId } ?: throw NoNoteException()
        val comment=note.comment.find { it.commentId == commentId }?: throw NoCommentException()
        tempComment+=comment
        note.comment.retainAll { it.commentId != commentId }
    }

    fun editNote(userId: Int, noteId: Int, title: String, text: String) {
        val noteList = noteLists[userId] ?: throw NoNoteListException()
        val note = noteList.notes.find { it.noteId == noteId } ?: throw NoNoteException()
        note.title = title
        note.text = text

    }

    fun editComment(userId: Int, noteId: Int, commentId: Int, text: String) {
        val noteList = noteLists[userId] ?: throw NoNoteListException()
        val note = noteList.notes.find { it.noteId == noteId } ?: throw NoNoteException()
        val comment=note.comment.find { it.commentId == commentId }?: throw NoCommentException()
        comment.text = text

    }


    fun getNote(userId: Int, noteId: String): List<Note> {
        val noteList = noteLists[userId] ?: throw NoNoteListException()

        var noteIdList = (noteId.split(", ")).map(String::toInt)
        var selectiveNote: List<Note> = mutableListOf()

        for (noteId in noteIdList) {
            val note = noteList.notes.find { it.noteId == noteId } ?: throw NoNoteException()
            selectiveNote += note
        }
        return selectiveNote
    }

    fun getNoteID(userId: Int, noteId: Int): Note? {
        val noteList = noteLists[userId] ?: throw NoNoteListException()
        return noteList.notes.find { it.noteId == noteId }
    }

    fun getComments(userId: Int, noteId: Int, count: Int): List<Comment> {
        val noteList = noteLists[userId] ?: throw NoNoteListException()
        val note = noteList.notes.find { it.noteId == noteId } ?: throw NoNoteException()
        return note.comment.takeLast(count)
    }

    fun restoreComment(userId: Int, noteId: Int, commentId: Int) {
        val noteList = noteLists[userId] ?: throw NoNoteListException()
        val note = noteList.notes.find { it.noteId == noteId } ?: throw NoNoteException()
        val comment=tempComment.find {it.commentId==commentId }?:throw NoCommentException()
        note.comment.add(comment)

    }

    fun printNoteLists() {
        println(noteLists)
        //  println(a)
    }
}




fun main() {
    NoteService.addNote(1, Note(noteId = 12, "Отдых", "Привет"))
    NoteService.addNote(4, Note(noteId = 23, "Развлечения", "Куда идем?"))
    NoteService.addNote(1, Note(noteId = 24, "Развлечения", "Куда идем?"))
    NoteService.addNote(1, Note(noteId = 13, "Развлечения", "Бар"))
    NoteService.deleteNote(1, 24)
    NoteService.addComment(1, 12, Comment(1, "С 13го по 14ое"))
    NoteService.addComment(4, 23, Comment(2, "С 13го по 14ое"))
    NoteService.addNote(5, Note(noteId = 24, "Развлечения", "Куда идем?"))
    println(NoteService.getComments(4, 23,1))
    NoteService.deleteComment(4, 23, 2)
    println(NoteService.getComments(4, 23,1))
    NoteService.restoreComment(4, 23, 2)
    NoteService.editNote(5,24,"Место", "Где собираемся?")
    NoteService.editComment(4, 23, 2,"14го числа")
    println(NoteService.getNoteID(1, 13))
    println(NoteService.getNote(1, "12, 13"))
    NoteService.printNoteLists()

}