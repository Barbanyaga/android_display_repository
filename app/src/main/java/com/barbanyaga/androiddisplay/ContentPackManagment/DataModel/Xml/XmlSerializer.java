package com.barbanyaga.androiddisplay.ContentPackManagment.DataModel.Xml;

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
            throw new Exception(String.format("Ошибка разбора файла %s", filePath));
        }
    }

    /**
     * Сохраняем в файл
     *
     * @param filePath
     */
    public static void serialize(String filePath) {
        try {
            File file = new File(filePath);

            if (file.exists()) {
                file.deleteOnExit();
            }

            Serializer serializer = new Persister();
            MasterProject masterProject = new MasterProject();

            // Файлы
            PlaylistFile playlistFile1 = new PlaylistFile("/sdcard/files/1.txt");
            PlaylistFile playlistFile2 = new PlaylistFile("/sdcard/files/readme.txt");
            PlaylistFile playlistFile3 = new PlaylistFile("/sdcard/files/video1.avi");
            PlaylistFile playlistFile4 = new PlaylistFile("/sdcard/files/video2.avi");

            // Плейлисты
            Playlist playlist1 = new Playlist();
            playlist1.playlistFiles.add(playlistFile1);
            playlist1.playlistFiles.add(playlistFile2);
            Playlist playlist2 = new Playlist();
            playlist2.playlistFiles.add(playlistFile3);
            playlist2.playlistFiles.add(playlistFile4);

            // Фрагменты
            FragmentDescription fragmentDescription1 = new FragmentDescription();
            fragmentDescription1.setFragmentType(FragmentType.Video);
            fragmentDescription1.setX(100);
            fragmentDescription1.setY(100);
            fragmentDescription1.setWidth(200);
            fragmentDescription1.setHeight(320);
            fragmentDescription1.setPlaylist(playlist2);
            FragmentDescription fragmentDescription2 = new FragmentDescription();
            fragmentDescription2.setFragmentType(FragmentType.CreepingText);
            fragmentDescription2.setX(150);
            fragmentDescription2.setY(74);
            fragmentDescription2.setWidth(51);
            fragmentDescription2.setHeight(127);
            fragmentDescription2.setPlaylist(playlist1);

            // Периодичность запуска проектов внутри мастре-проекта
            FrequencyConfig frequencyConfig1 = new FrequencyConfig();
            frequencyConfig1.setFrequencyType(FrequencyType.EveryNMinutes);
            frequencyConfig1.setFrequencyN(1);

            // Проекты
            Project project1 = new Project();
            project1.fragmentDescriptions = new ArrayList<FragmentDescription>();
            project1.frequencyConfig = frequencyConfig1;
            project1.fragmentDescriptions.add(fragmentDescription1);
            project1.fragmentDescriptions.add(fragmentDescription2);

            // Мастер-проект
            masterProject.Projects = new ArrayList<Project>();
            masterProject.Projects.add(project1);

            serializer.write(masterProject, file);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}