package lesson4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends HttpServlet {
	// �ϴ��ļ��Ĵ��·��
	static String SAVE_DIR = "E:/test";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		// �����ļ�
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		// �ж��Ƿ����ļ��ϴ�����
		if (isMultipart) {
			// �û����������ļ��ϴ��Ĺ�����
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// Ĭ���ϴ��ļ� ��ʱ�������ʱĿ¼ System.getProperty("java.io.tmpdir);
			// ������Tomcat/tempĿ¼

			// ���ڴ������н����ļ�
			ServletFileUpload upload = new ServletFileUpload(factory);
			// �����ַ�����
			upload.setHeaderEncoding("utf-8");

			try {
				// �������յ����ļ������ı���
				List<FileItem> items = upload.parseRequest(request);
				// ��ӡ�ϴ����ļ�����
				// System.out.println(fileItems.size());
				for (FileItem item : items) {
					// �ж��Ƿ����ı���
					if (item.isFormField()) {
						System.out.println(item.getFieldName() + "-------" + item.getString());
					} else {
						// ��ȡ�ϴ����ļ���
						String fileName = item.getName();
						// �ļ�����·��
						String destPath = SAVE_DIR + "/" + fileName;

						System.out.println(destPath);
						// ��ȡ������
						InputStream iStream = item.getInputStream();
						// ��������������ϴ����ļ������ڷ�����
						FileOutputStream fOutputStream = new FileOutputStream(destPath);
						byte[] bs = new byte[1024];
						int read = -1;
						while ((read = iStream.read(bs)) != -1) {
							fOutputStream.write(bs, 0, read);
						}
						// �ر���ͨ��
						iStream.close();
						fOutputStream.close();

					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			}

		}
		//�ļ��ϴ����ض���MyShareDownLoad����
		response.sendRedirect(request.getContextPath() + "/share");

	}

}
