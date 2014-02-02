package com.sport.coach.service.impl;

import com.sport.coach.domain.activity.Activity;
import com.sport.coach.domain.user.User;
import com.sport.coach.domain.view.FileUpload;
import com.sport.coach.domain.xml.ActivityXml;
import com.sport.coach.error.ClientServerException;
import com.sport.coach.error.ErrorTypes;
import com.sport.coach.mappers.XmlMapper;
import com.sport.coach.repository.dao.SportCoachDao;
import com.sport.coach.service.FileUploadService;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.ParseException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author luku00
 */
public class FileUploadServiceImpl implements FileUploadService {

    private SportCoachDao sportCoachDao;
    private XmlMapper xmlMapper;

    @Override
    public void createActivityFromXmlFile(FileUpload uploadedFile, User user, String activityType) throws ParseException, ClientServerException {
        MultipartFile file = uploadedFile.getFile();
        String transformedXml = transformInputFile(file, "importActivity.xsl");
        ActivityXml activityXml = (ActivityXml) unmarshallXml(transformedXml, ActivityXml.class);
        checkIfFileHasNotBeenImported(activityXml.getOriginId());
        Activity activity = xmlMapper.mapActivityFromActivityXml(activityXml);
        activity.setUser(user);
        activity.setType(activityType);
        sportCoachDao.saveActivity(activity);
    }

    private void checkIfFileHasNotBeenImported(String uniqueId) throws ClientServerException {
        if (sportCoachDao.importActivityExist(uniqueId)) {
            throw new ClientServerException(ErrorTypes.FILE_ALREADY_IMPORTED.name());
        }
    }

    private Object unmarshallXml(String xml, Class cl) {
        Object obj = null;
        try {
            JAXBContext jc = JAXBContext.newInstance(cl);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            StringReader reader = new StringReader(xml);
            obj = unmarshaller.unmarshal(reader);
        } catch (JAXBException e) {
        }
        return obj;
    }

    /**
     * This will transform input xml into inner xml
     *
     * @param file
     * @param xlsTemplate
     * @return
     */
    private String transformInputFile(MultipartFile file, String xlsTemplate) {
        String result = null;
        try {
            TransformerFactory tFactory = TransformerFactory.newInstance();
            StringWriter writer = new StringWriter();
            Source xslDoc = new StreamSource(xlsTemplate);
            Source xmlDoc = new StreamSource(file.getInputStream());
            Transformer transformer = tFactory.newTransformer(xslDoc);
            transformer.transform(xmlDoc, new StreamResult(writer));
            result = writer.toString();
        } catch (IOException | TransformerException e) {
        }
        return result;
    }

    public void setSportCoachDao(SportCoachDao sportCoachDao) {
        this.sportCoachDao = sportCoachDao;
    }

    public void setXmlMapper(XmlMapper xmlMapper) {
        this.xmlMapper = xmlMapper;
    }

}
