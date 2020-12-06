public class MinimumRequirements extends GameRequirements
{
    public MinimumRequirements(double vertexShader, double pixelShader, String amdCpu, String intelCpu, String AMDGpu, String intelGpu, int cpuCoreCount, double cpuClockSpeed, int ram, String os, double gpuVRAM, int diskSpace)
    {
        super(vertexShader, pixelShader, amdCpu, intelCpu, AMDGpu, intelGpu, cpuCoreCount, cpuClockSpeed, ram, os, gpuVRAM, diskSpace);
    }

    public void printMinimumRequirements()
    {
        System.out.println("-----Minimum System requirements-----\n"+
                "CPU: "+this.getIntelCpu()+" or "+this.getAmdCpu()+"\n"+
                "RAM: "+this.getRam()+"GB\n"+
                "OS; "+this.getOs()+"\n"+
                "VIDEO CARD: "+this.getNvidiaGpu()+" or "+getAMDGpu()+"\n"+
                "PIXEL SHADER: "+this.getPixelShader()+"\n"+
                "VERTEX SHADER: "+this.getVertexShader()+"\n"+
                "FREE DISK SPACE: "+this.getDiskSpace()+"\n"+
                "DEDICATED VIDEO RAM: "+this.getGpuVRAM());
    }
}
