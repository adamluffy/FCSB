/**
 * Copyright
 *
 * @author Mohd Adam Bin Ezanee
 * @since 21/10/2018
 * @version 0.0.1
 */

package respository;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Map;

import model.equipment.Machinery;




/**
 * A firestore real time database helper that create,
 * read, update and delete machinery data.
 */

public class MachineryRepository implements FirestoreOperation<Machinery> {

    /**
     * machinery collection reference for firestore database
     */
    private CollectionReference ref;

    //default constructor , set private to prevent duplication of object
    private MachineryRepository(){
        this.ref = FirebaseFirestore.getInstance().collection("machinery");
    }

    /**
     *
     * @return
     */
    public static MachineryRepository getInstance(){
        return new MachineryRepository();
    }

    /**
     *
     * @param object
     * @return
     */
    @Override
    public Task<DocumentReference> add(Machinery object) {
        return ref.add(object);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Task<Void> remove(String id) {
        return ref.document(id).delete();
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Task<DocumentSnapshot> get(String id) {
        return ref.document(id).get();
    }

    /**
     *
     * @param id
     * @param updates
     * @return
     */
    @Override
    public Task<Void> update(String id, Map<String, Object> updates) {
        return ref.document(id).update(updates);
    }

    /**
     *
     * @return
     */
    @Override
    public Task<QuerySnapshot> list() {
        return ref.get();
    }


}
