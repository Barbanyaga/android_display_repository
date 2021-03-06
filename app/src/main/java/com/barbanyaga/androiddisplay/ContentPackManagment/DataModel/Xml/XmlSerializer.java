package com.barbanyaga.androiddisplay.ContentPackManagment.DataModel.Xml;

import android.util.Log;

import com.barbanyaga.androiddisplay.AppConfig;
import com.barbanyaga.androiddisplay.ContentPackManagment.DataModel.Enums.FrequencyType;
import com.barbanyaga.androiddisplay.ContentPackManagment.DataModel.FragmentDescription;
import com.barbanyaga.androiddisplay.ContentPackManagment.DataModel.Enums.FragmentType;
import com.barbanyaga.androiddisplay.ContentPackManagment.DataModel.FrequencyConfig;
import com.barbanyaga.androiddisplay.ContentPackManagment.DataModel.MasterProject;
import com.barbanyaga.androiddisplay.ContentPackManagment.DataModel.Playlist;
import com.barbanyaga.androiddisplay.ContentPackManagment.DataModel.PlaylistFile;
import com.barbanyaga.androiddisplay.ContentPackManagment.DataModel.Project;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by barbanyaga on 23.03.2015.
 */
public class XmlSerializer {

    /**
     * Разбираем XML в мастер-пакет
     *
     * @param filePath
     * @return
     * @throws Exception
     */
    public static MasterProject deserialize(String filePath) throws Exception {
        File file = new File(filePath);

        if (!file.exists()) {
            throw new IOException(String.format("Файл %s не найден", filePath));
        }

        Serializer serializer = new Persister();
        try {
            MasterProject masterProject = serializer.read(MasterProject.class, file);
            return masterProject;
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Deserialize xml", e.getMessage());
            throw new Exception(String.format("Ошибка разбора файла %s", filePath));
        }
    }

    /**
     * Сохраняем в файл (mock)
     *
     * @param filePath
     */
//    public static void serialize(String filePath) {
//        try {
//            File file = new File(filePath);
//
//            if (file.exists()) {
//                file.deleteOnExit();
//            }
//
//            Serializer serializer = new Persister();
//            MasterProject masterProject = new MasterProject();
//
//            // Файлы
//            PlaylistFile playlistFile1 = new PlaylistFile("/sdcard/files/1.txt");
//            PlaylistFile playlistFile2 = new PlaylistFile("/sdcard/files/readme.txt");
//            PlaylistFile playlistFile3 = new PlaylistFile("/sdcard/files/video1.avi");
//            PlaylistFile playlistFile4 = new PlaylistFile("/sdcard/files/video2.avi");
//
//            // Плейлисты
//            Playlist playlist1 = new Playlist();
//            playlist1.playlistFiles.add(playlistFile1);
//            playlist1.playlistFiles.add(playlistFile2);
//            Playlist playlist2 = new Playlist();
//            playlist2.playlistFiles.add(playlistFile3);
//            playlist2.playlistFiles.add(playlistFile4);
//
//            // Фрагменты
//            FragmentDescription fragmentDescription1 = new FragmentDescription();
//            fragmentDescription1.setFragmentType(FragmentType.Video);
//            fragmentDescription1.setLeft(100);
//            fragmentDescription1.setTop(100);
//            fragmentDescription1.setWidth(200);
//            fragmentDescription1.setHeight(320);
//            fragmentDescription1.setPlaylist(playlist2);
//            FragmentDescription fragmentDescription2 = new FragmentDescription();
//            fragmentDescription2.setFragmentType(FragmentType.CreepingText);
//            fragmentDescription2.setLeft(150);
//            fragmentDescription2.setTop(74);
//            fragmentDescription2.setWidth(51);
//            fragmentDescription2.setHeight(127);
//            fragmentDescription2.setPlaylist(playlist1);
//
//            // Периодичность запуска проектов внутри мастре-проекта
//            FrequencyConfig frequencyConfig1 = new FrequencyConfig();
//            frequencyConfig1.setFrequencyType(FrequencyType.EveryNMinutes);
//            frequencyConfig1.setFrequencyN(1);
//
//            // Проекты
//            Project project1 = new Project();
//            project1.fragmentDescriptions = new ArrayList<FragmentDescription>();
//            project1.frequencyConfig = frequencyConfig1;
//            project1.fragmentDescriptions.add(fragmentDescription1);
//            project1.fragmentDescriptions.add(fragmentDescription2);
//
//            // Мастер-проект
//            masterProject.AdProjects = new ArrayList<Project>();
//            masterProject.AdProjects.add(project1);
//
//            serializer.write(masterProject, file);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * Сериализует реальный пример Мастер-проекта
     *
     * @param filePath
     */
    public static void serializeRealSample(String filePath) {
        try {
            File file = new File(filePath);

            if (file.exists()) {
                file.deleteOnExit();
            }


            // Файлы
            PlaylistFile playlistFile0 = new PlaylistFile(AppConfig.defaultPath + "/Projects/1/Videos/Life.Cycles.2010.1080p.Rus.Eng.mp4");

            PlaylistFile playlistFile1 = new PlaylistFile(AppConfig.defaultPath + "/Projects/2/Texts/1.txt");
            PlaylistFile playlistFile2 = new PlaylistFile(AppConfig.defaultPath + "/Projects/2/Texts/2.txt");
            PlaylistFile playlistFile3 = new PlaylistFile(AppConfig.defaultPath + "/Projects/2/Texts/3.txt");
            PlaylistFile playlistFile4 = new PlaylistFile(AppConfig.defaultPath + "/Projects/2/Htmls/Weather.html");
            PlaylistFile playlistFile5 = new PlaylistFile(AppConfig.defaultPath + "/Projects/2/Videos/город.mp4");

            // Плейлисты
            Playlist playlistMainVideo = new Playlist(); // Видео основного проекта
            playlistMainVideo.playlistFiles.add(playlistFile0);

            Playlist playlistTexts = new Playlist(); // Плейлисты второго проекта
            playlistTexts.playlistFiles.add(playlistFile1);
            playlistTexts.playlistFiles.add(playlistFile2);
            playlistTexts.playlistFiles.add(playlistFile3);

            Playlist playlistHtmls = new Playlist();
            playlistHtmls.playlistFiles.add(playlistFile4);

            Playlist playlistVideos = new Playlist();
            playlistVideos.playlistFiles.add(playlistFile5);

            // Фрагменты
            FragmentDescription videoFragment0 = new FragmentDescription(); // 0, 60, 1920, 1080
            videoFragment0.setFragmentType(FragmentType.Video);
            videoFragment0.setLeft(0);
            videoFragment0.setTop(60);
            videoFragment0.setWidth(1920);
            videoFragment0.setHeight(1080);
            videoFragment0.setPlaylist(playlistMainVideo);

            FragmentDescription videoFragment = new FragmentDescription(); // 0, 60, 1920, 1080
            videoFragment.setFragmentType(FragmentType.Video);
            videoFragment.setLeft(0);
            videoFragment.setTop(60);
            videoFragment.setWidth(1920);
            videoFragment.setHeight(1080);
            videoFragment.setPlaylist(playlistVideos);
            FragmentDescription textFragment = new FragmentDescription(); // 20, 1080, 1920, 70, 0
            textFragment.setFragmentType(FragmentType.CreepingText);
            textFragment.setLeft(20);
            textFragment.setTop(1080);
            textFragment.setWidth(1920);
            textFragment.setHeight(70);
            textFragment.setPlaylist(playlistTexts);
            FragmentDescription htmlFragment = new FragmentDescription(); // 1700, 50, 600, 1200, 0
            htmlFragment.setFragmentType(FragmentType.Html);
            htmlFragment.setLeft(1700);
            htmlFragment.setTop(50);
            htmlFragment.setWidth(600);
            htmlFragment.setHeight(1200);
            htmlFragment.setPlaylist(playlistHtmls);

            // Периодичность запуска проектов внутри мастер-проекта
            FrequencyConfig frequencyConfig0 = new FrequencyConfig();
            frequencyConfig0.setFrequencyType(FrequencyType.None);
            frequencyConfig0.setFrequencyN(0);

            FrequencyConfig frequencyConfig1 = new FrequencyConfig();
            frequencyConfig1.setFrequencyType(FrequencyType.EveryNMinutes);
            frequencyConfig1.setFrequencyN(60);

            // Проекты
            Project mainProject = new Project();
            mainProject.frequencyConfig = frequencyConfig0;
            mainProject.fragmentDescriptions = new ArrayList<FragmentDescription>();
            mainProject.fragmentDescriptions.add(videoFragment0);

            Project project1 = new Project();
            project1.frequencyConfig = frequencyConfig1;
            project1.fragmentDescriptions = new ArrayList<FragmentDescription>();
            project1.fragmentDescriptions.add(videoFragment);
            project1.fragmentDescriptions.add(textFragment);
            project1.fragmentDescriptions.add(htmlFragment);

            // Мастер-проект
            MasterProject masterProject = new MasterProject();
            masterProject.MainProject = mainProject;
            masterProject.AdProjects = new ArrayList<Project>();
            masterProject.AdProjects.add(project1);

            Serializer serializer = new Persister();
            serializer.write(masterProject, file);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
