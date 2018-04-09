package com.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StoryService {
    private JdbcTemplate template;
    private DataSource dataSource;
    Connection connection = null;
    Story story =new Story();

    public StoryService(DataSource dataSource) throws SQLException {
        this.dataSource = dataSource;
        connection = dataSource.getConnection();
    }

    public void setTemplate(JdbcTemplate t) {
        this.template = t;
    }

    public List<Story> getStoryList() throws SQLException {
        String sql="SELECT * FROM story";
        connection = dataSource.getConnection();

        return template.query(sql, new RowMapper<Story>() {
            public Story mapRow(ResultSet resultSet, int i) throws SQLException {
                story = new Story();
                story.setStoryId(resultSet.getInt("story_id"));
                story.setStoryTitle(resultSet.getString("story_title"));
                story.setStoryAuthor(resultSet.getString("story_author"));
                story.setStoryDetails(resultSet.getString("story_details"));
                return story;
            }
        });

    }

    public Story getStoryDetails(int story_id) throws SQLException {
        String sql="SELECT * FROM story WHERE story_id = ?";
        connection = dataSource.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, story_id);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            story.setStoryId(rs.getInt("story_id"));
            story.setStoryTitle(rs.getString("story_title"));
            story.setStoryAuthor(rs.getString("story_author"));
            story.setStoryDetails(rs.getString("story_details"));
        }

        ps.close();
        connection.close();
        return story;
    }

    public void createNewsStory(Story story) throws SQLException{
        String sql="INSERT INTO `story`(`story_title`, `story_author`, `story_details`) values( ? , ? , ?)";
        connection = dataSource.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1, story.getStoryTitle());
        ps.setString(2, story.getStoryAuthor());
        ps.setString(3, story.getStoryDetails());
        ps.executeUpdate();
        ps.close();
        connection.close();

    }

    public void updateNewsStory(Story story) throws SQLException{
        String sql="UPDATE `story` SET `story_title`= ? ,`story_author`= ? ,`story_details`= ? WHERE story_id = ?";
        connection = dataSource.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1, story.getStoryTitle());
        ps.setString(2, story.getStoryAuthor());
        ps.setString(3, story.getStoryDetails());
        ps.setInt(4, story.getStoryId());
        ps.executeUpdate();
        ps.close();
        connection.close();

    }

    public void deleteNewsStory(int id) throws SQLException{
        String sql="DELETE FROM `story` WHERE story_id = ?";
        connection = dataSource.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        connection.close();

    }

}