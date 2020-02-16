package om.metamorph.storagemanager;

public interface IStorageManager {
    String moveFileToPermanentLocation(String cognitoSub, String logoKey);

    boolean keyExistsInUploadStorage(String s);

    void deleteFile(String logoKey);
}
