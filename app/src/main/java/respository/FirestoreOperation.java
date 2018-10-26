package respository;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Map;

public interface FirestoreOperation<T> {

    Task<DocumentReference> add(T object);
    Task<Void> remove(String id);
    Task<DocumentSnapshot> get(String id);
    Task<Void> update(String id, Map<String,Object> updates);
    Task<QuerySnapshot> list();
}
