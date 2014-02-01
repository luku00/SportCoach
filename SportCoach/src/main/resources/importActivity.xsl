<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:t="http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2">

    <xsl:template match="/t:TrainingCenterDatabase">
        <ACTIVITY>
            <xsl:for-each select="t:Activities/t:Activity">
                <ORIGINID>
                    <xsl:value-of select="t:Id"/>
                </ORIGINID>
                <TIMESTART>
                    <xsl:value-of select="t:Lap/@StartTime"/>
                </TIMESTART>
                <xsl:for-each select="t:Lap">
                    <TOTALTIMEINSECONDS>
                        <xsl:value-of select="t:TotalTimeSeconds"/>
                    </TOTALTIMEINSECONDS>
                    <DISTANCEINMETERS>
                        <xsl:value-of select="t:DistanceMeters"/>
                    </DISTANCEINMETERS>
                    <CALORIES>
                        <xsl:value-of select="t:Calories"/>
                    </CALORIES>
                </xsl:for-each>
            </xsl:for-each>
        </ACTIVITY>
    </xsl:template>

</xsl:stylesheet>
