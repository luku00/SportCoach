<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:t="http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2">

<!-- Aktualne se povoluje naimportovat ouze jedna aktivita .. bere se teda pouze prvni -->
    <xsl:template match="/t:TrainingCenterDatabase/t:Activities/t:Activity[1]">
        <ACTIVITY>
            <ORIGINID>
                <xsl:value-of select="t:Id"/>
            </ORIGINID>
            <TIMESTART>
                <xsl:value-of select="t:Lap/@StartTime"/>
            </TIMESTART>
            <TOTALTIMEINSECONDS>
                <xsl:value-of select="t:Lap/t:TotalTimeSeconds"/>
            </TOTALTIMEINSECONDS>
            <DISTANCEINMETERS>
                <xsl:value-of select="t:Lap/t:DistanceMeters"/>
            </DISTANCEINMETERS>
            <CALORIES>
                <xsl:value-of select="t:Lap/t:Calories"/>
            </CALORIES>
            <TRACKS>
                <xsl:for-each select="t:Lap/t:Track/t:Trackpoint">
                    <TRACK>
                        <TIME>
                            <xsl:value-of select="./t:Time"/>
                        </TIME>
                        <LATITDE>
                            <xsl:value-of select="./t:Position/t:LatitudeDegrees"/>
                        </LATITDE>
                        <LONGTITUDE>
                            <xsl:value-of select="./t:Position/t:LongitudeDegrees"/>
                        </LONGTITUDE>
                    </TRACK>
                </xsl:for-each>
            </TRACKS>
        </ACTIVITY>
    </xsl:template>

</xsl:stylesheet>
