package om.metamorph.storagemanager.s3manager;

import om.metamorph.storagemanager.IStorageManager;

public class S3Manager implements IStorageManager {
    @Override
    public String moveFileToPermanentLocation(String cognitoSub, String logoKey) {
        //Do whatever you need to move file to new location
        String newLogoKey = "0987.png";
        return newLogoKey;
    }

    @Override
    public boolean keyExistsInUploadStorage(String s) {
        //Use S3 sdk to check if this key exists in upload storage, return true if found
        return true;
    }

    @Override
    public void deleteFile(String logoKey) {
        //use s3 to delete file
    }
}
