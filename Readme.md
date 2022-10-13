# Praktikum Mobile Programming

## Praktikan

- [Ariel Matius Surbakti](https://www.github.com/octokatherine)

### Cara clone project dan mengganti nama

Using Windows Explorer, navigate to the Android Studio projects directory select the project folder to be cloned;

Copy the selected folder;

Paste the folder into the Android Studio (AS) projects directory;

Rename the pasted folder to be the new name of the cloned project, say 'ViewPager_Shell';

Launch Android Studio;

Select 'Open an existing Android Studio project';

Navigate to the AS projects directory;

Select the folder 'ViewPager_Shell';

Ensure that AS's explorer pane is visible on the left-hand-side of the AS main frame;

Select the 'Android' view for the explorer pane;

Open app -> java; the old package name should now be visible, e.g. 'com.hulme.owm';

Right-click on the old package name and select 'Refactor -> Rename';

A dialog should now appear; left-click 'Rename Package';

In the pop-up dialog, replace the old package (e.g. 'owm') with the new package name (e.g. viewpager_shell);

Left-click on the 'Refactor' button; BEWARE!! ... A new 'Find Factoring Preview' pane should open in the lower-left of the AS main frame window;

Select 'Do Refactor';

Using the AS explorer pane, navigate to 'Gradle Scripts -> build.gradle(Module:app);

Double-click build.gradle(Module:app) to view its contents in the AS editor pane;

Change the defaultConfig 'applicationID' string to your new full package path (e.g. "com.hulme.viewpager_shell");

Using the AS explorer pane, navigate to 'app -> manifests -> AndroidManifest.xml';

Double-click on 'AndroidManifest.xml' to view it in the AS editor pane;

Under the manifest tag, you should observe that the new package name (e.g. 'com.hulme.viewpager_shell') now appears, as a result of the previous refactoring step;

Under application tag, change android:label to a new name (e.g. "ViewPager Shell Demo") - this is the name that appears in the list of installed apps provided by Android's 'Settings -> Application manager;

Under activity tag, change android:label to a new name (e.g. "VP Shell") - this is the name that appears under the app's icon and it is also the activity's default ActionBar title;

You should now be able to build and run the newly cloned project.
