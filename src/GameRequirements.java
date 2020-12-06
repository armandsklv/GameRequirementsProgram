public class GameRequirements
{
    private double VertexShader;
    private double PixelShader;
    private String AmdCpu;
    private String IntelCpu;
    private String AMDGpu;
    private String nvidiaGpu;
    private int cpuCoreCount;
    private double cpuClockSpeed;
    private int ram;
    private String os;
    private double gpuVRAM;
    private int diskSpace;


    public GameRequirements(double vertexShader, double pixelShader, String amdCpu, String intelCpu, String AMDGpu, String nvidiaGpu, int cpuCoreCount, double cpuClockSpeed, int ram, String os, double gpuVRAM, int diskSpace)
    {
        VertexShader = vertexShader;
        PixelShader = pixelShader;
        AmdCpu = amdCpu;
        IntelCpu = intelCpu;
        this.AMDGpu = AMDGpu;
        this.nvidiaGpu = nvidiaGpu;
        this.cpuCoreCount = cpuCoreCount;
        this.cpuClockSpeed = cpuClockSpeed;
        this.ram = ram;
        this.os = os;
        this.gpuVRAM = gpuVRAM;
        this.diskSpace = diskSpace;
    }

    public double getVertexShader()
    {
        return VertexShader;
    }

    public void setVertexShader(double vertexShader)
    {
        VertexShader = vertexShader;
    }

    public double getPixelShader()
    {
        return PixelShader;
    }

    public void setPixelShader(double pixelShader)
    {
        PixelShader = pixelShader;
    }

    public String getAmdCpu()
    {
        return AmdCpu;
    }

    public void setAmdCpu(String amdCpu)
    {
        AmdCpu = amdCpu;
    }

    public void setCpuClockSpeed(double cpuClockSpeed)
    {
        this.cpuClockSpeed = cpuClockSpeed;
    }

    public String getIntelCpu()
    {
        return IntelCpu;
    }

    public void setIntelCpu(String intelCpu)
    {
        IntelCpu = intelCpu;
    }

    public String getAMDGpu()
    {
        return AMDGpu;
    }

    public void setAMDGpu(String AMDGpu)
    {
        this.AMDGpu = AMDGpu;
    }

    public String getNvidiaGpu()
    {
        return nvidiaGpu;
    }

    public void setNvidiaGpu(String intelGpu)
    {
        nvidiaGpu = intelGpu;
    }

    public int getCpuCoreCount()
    {
        return cpuCoreCount;
    }

    public void setCpuCoreCount(int cpuCoreCount)
    {
        this.cpuCoreCount = cpuCoreCount;
    }

    public double getCpuClockSpeed()
    {
        return cpuClockSpeed;
    }

    public int getRam()
    {
        return ram;
    }

    public void setRam(int ram)
    {
        this.ram = ram;
    }

    public String getOs()
    {
        return os;
    }

    public void setOs(String os)
    {
        this.os = os;
    }

    public double getGpuVRAM()
    {
        return gpuVRAM;
    }

    public void setGpuVRAM(double gpuVRAM)
    {
        this.gpuVRAM = gpuVRAM;
    }

    public int getDiskSpace()
    {
        return diskSpace;
    }

    public void setDiskSpace(int diskSpace)
    {
        this.diskSpace = diskSpace;
    }
}
